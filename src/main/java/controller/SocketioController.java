package controller;

import com.jfinal.core.Controller;

/**
 * Created by Administrator on 2017/12/25 0025.
 */
public class SocketioController extends Controller {

    public void index(){
        render("message.html");
    }
}
