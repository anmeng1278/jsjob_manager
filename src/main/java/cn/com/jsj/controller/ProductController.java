package cn.com.jsj.controller;

import cn.com.jsj.entity.Product;
import cn.com.jsj.entity.ProductType;
import cn.com.jsj.exception.JsjException;
import cn.com.jsj.form.ProductForm;
import cn.com.jsj.service.OrderProductService;
import cn.com.jsj.service.ProductService;
import cn.com.jsj.service.ProductTypeService;
import cn.com.jsj.utils.KeyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private OrderProductService orderProductService;

    /**
     * 查找商品列表
     *
     * @param page
     * @param size
     * @param map
     * @param
     * @return
     */
    @GetMapping("/list")
    public ModelAndView productList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                    Map<String, Object> map) {
        PageHelper.startPage(page, size);
        //商品列表
        List<Product> productList = productService.findAll();
        for(Product product : productList){
            String productId = product.getProductVO().getProductId();
            //计算商品剩余量
            int productInventory = orderProductService.calcProductInventory(productId);
        }
        //分页查询后的数据
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        map.put("productList", productList);
       // map.put("productInventory", productInventory);
        map.put("pageInfo", pageInfo);
        map.put("total", pageInfo.getTotal());
        map.put("currentPage", page);
        return new ModelAndView("admin/TProduct/index", map);
    }


    /**
     * 保存/更新
     *
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    @Transactional
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/jsjob_manager/product/index");
            return new ModelAndView("common/error_404", map);
        }
        Product productInfo = new Product();
        try {
            //如果productId为空, 说明是新增
            if (!StringUtils.isEmpty(form.getId())) {
                productInfo = productService.findOne(form.getId());
            } else {
                form.setId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form, productInfo);
            productService.save(productInfo);
        } catch (JsjException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/jsjob_manager/product/index");
            return new ModelAndView("common/error_404", map);
        }
        map.put("url", "/jsjob_manager/product/list");
        return new ModelAndView("common/success", map);
    }


    /**
     * 信息页面展示
     *
     * @param productId
     * @param model
     * @return
     */
    @GetMapping("/index/{productId}")
    public String index(@PathVariable("productId") String productId,
                              Model model) {
        if (!StringUtils.isEmpty(productId)) {
            Product productInfo = productService.findOne(productId);
            model.addAttribute("productInfo", productInfo);
        }
        //查询所有的类目
        List<ProductType> productTypeList = productTypeService.findAll();
        model.addAttribute("productTypeList", productTypeList);
        return "admin/TProduct/info";
    }

    /**
     * 根据商品名字关键字搜索
     *
     * @param title
     * @param model
     * @return
     */

    @GetMapping("/findByProductName")
    public String findByProductName(@RequestParam(value = "title") String title, Model model) {
        List<Product> productList = productService.findByProductName(title);
        model.addAttribute("productList", productList);
        return "admin/TProduct/index";
    }

    /**
     * 根据ID删除商品
     *
     * @param productId
     * @param model
     * @return
     */
    @RequestMapping("/delete/{productId}")
    public String deleteById(@PathVariable(value = "productId") String productId, Model model) {
        try {
            productService.deleteById(productId);
        } catch (JsjException e) {
            model.addAttribute("msg", e.getMessage());
            return "common/error_404";
        }
        return "redirect:/product/list";
    }


    /**
     * 计算商品库存剩余量
     * @param productId
     * @param total
     * @return
     */
    /*
   private int calcProductInventoryBalance(String productId, int total){
        try{
            int salesCount = orderProductDao.calcProductSalesCount(productId);
            logger.debug("calcProductInventoryBalance productId:"+productId+", total:"+total+", salesCount:"+salesCount);
            if(salesCount < total){
                return total - salesCount;
            }
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    */
}
