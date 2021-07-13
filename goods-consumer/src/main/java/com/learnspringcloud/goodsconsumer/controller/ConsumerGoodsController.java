package com.learnspringcloud.goodsconsumer.controller;

import com.entity.Cart;
import com.entity.Goods;
import com.entity.Userorder;
import com.learnspringcloud.goodsconsumer.service.CartService;
import com.learnspringcloud.goodsconsumer.service.GoodsService;
import com.learnspringcloud.goodsconsumer.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Controller
@RequestMapping("/goods")
public class ConsumerGoodsController {

    @Resource
    GoodsService goodsService;
    @Resource
    CartService cartService;
    @Resource
    OrderService orderService;

    @GetMapping("/quit")
    public String quit(HttpSession session){
        session.removeAttribute("uaccount");
        return "redirect:http://localhost:8893/admin/tologin";
    }

    @GetMapping("/getAll")
    public String getAllGoods(HttpServletRequest request,String uaccount,HttpSession session){
        session.setAttribute("uaccount",uaccount);
        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();

        List<Goods> allGoods = goodsService.getAllGoods();
        for (Goods allGood : allGoods) {
            if (allGood.getTypes().equals(0)){
                goods1.add(allGood);
            }
            if (allGood.getTypes().equals(2)){
                goods2.add(allGood);
            }
            if (allGood.getTypes().equals(1)){
                goods3.add(allGood);
            }
            if (allGood.getTypes().equals(3)){
                goods4.add(allGood);
            }
        }
        request.setAttribute("goods1",goods1);
        request.setAttribute("goods2",goods2);
        request.setAttribute("goods3",goods3);
        request.setAttribute("goods4",goods4);

        return "index";
    }

    @GetMapping("/getOne")
    public String getLikeGoods(HttpServletRequest request,String name){
        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();

        List<Goods> allGoods = goodsService.getLikeGoods(name);
        for (Goods allGood : allGoods) {
            if (allGood.getTypes().equals(0)){
                goods1.add(allGood);
            }
            if (allGood.getTypes().equals(2)){
                goods2.add(allGood);
            }
            if (allGood.getTypes().equals(1)){
                goods3.add(allGood);
            }
            if (allGood.getTypes().equals(3)){
                goods4.add(allGood);
            }
        }
        request.setAttribute("goods1",goods1);
        request.setAttribute("goods2",goods2);
        request.setAttribute("goods3",goods3);
        request.setAttribute("goods4",goods4);
        return "index";
    }

    @GetMapping("/detail")
    public String detail(HttpServletRequest request,int gid){
        Goods idGoods = goodsService.getIdGoods(gid);
        request.setAttribute("detail",idGoods);
        return "detail";
    }

    //加入购物车
    @GetMapping("/cart")
    public String insertCart(HttpServletRequest request,HttpSession session,
                             String che,String name,String price, String number){
        String uid = (String) session.getAttribute("uaccount");
        int uid1 = Integer.parseInt(uid);
        List <Cart> allCart = cartService.getAllCart(uid1);
        int goodsid = Integer.parseInt(che);
        int price1 = Integer.parseInt(price);
        int number1 = Integer.parseInt(number);

        if (allCart.size() == 0){
            cartService.insertCart(name,number1,price1,goodsid,uid1);
            return "redirect:/goods/cartAll";
        }
        Boolean flag = false;
        for (Cart cart : allCart) {
            if (cart.getGoodid().equals(goodsid)){
                cartService.updateCart(number1,cart.getId());
                return "redirect:/goods/cartAll";
            }else {
                flag = true;
            }
        }
        if (flag){
            cartService.insertCart(name,number1,price1,goodsid,uid1);
        }

        return "redirect:/goods/cartAll";
    }

    //我的购物车
    @GetMapping("/cartAll")
    public String getAllCart(HttpServletRequest request,HttpSession session){
        String uid = (String) session.getAttribute("uaccount");
        List<Cart> allCart = cartService.getAllCart(Integer.parseInt(uid));
        int totalNum = 0;
        int totalPrice = 0;
        for (Cart cart : allCart) {
            totalNum += cart.getNumber();
            totalPrice += (cart.getNumber() * cart.getPrice());
        }
        request.setAttribute("carts",allCart);
        request.setAttribute("totalNum",totalNum);
        request.setAttribute("totalPrice",totalPrice);
        return "Settle";
    }

    @GetMapping("/deleteCart")
    public String deleteCart(HttpServletRequest request,String did){
         cartService.deleteCart(Integer.parseInt(did));
        return "redirect:/goods/cartAll";
    }

    //添加订单并删除购物车里的商品
    @GetMapping("/paygoods")
    public String insertOrder(String[] goodid,String[] numaa,String[] id,
                              HttpServletRequest request,HttpSession session){
        String  uid = (String) session.getAttribute("uaccount");
        if (goodid.length == 0 || numaa.length == 0 || id.length == 0){
            return "redirect:/goods/cartAll";
        }else {
            for (int i = 0; i < goodid.length; i++) {
                cartService.insertOrder(goodsService.getIdGoods(Integer.parseInt(goodid[i])).gname,
                        Integer.parseInt(numaa[i]),
                        Integer.parseInt(numaa[i]) * goodsService.getIdGoods(Integer.parseInt(goodid[i])).gprice,
                        Integer.parseInt(uid));
                cartService.deleteCart(Integer.parseInt(id[i]));
            }
            return "redirect:/goods/cartAll";
        }
    }

    @GetMapping("/getAllorder")
    public String getAllOrder(HttpSession session,HttpServletRequest request){
        String  uid = (String) session.getAttribute("uaccount");
        if (uid.equals(null)){
            return "redirect:http://localhost:8893/admin/tologin";
        }
        List<Userorder> allOrder = orderService.getAllOrder(Integer.parseInt(uid));
        request.setAttribute("order",allOrder);
        return "order";
    }


}
