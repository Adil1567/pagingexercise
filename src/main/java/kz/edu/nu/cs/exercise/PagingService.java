package kz.edu.nu.cs.exercise;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/items")
public class PagingService {

    private List<String> list = new CopyOnWriteArrayList<String>();

    public PagingService() {
        for (int i = 0; i < 100; i++) {
            list.add("Entry " + String.valueOf(i));
        }
    }

    @GET

    public Response getMyList(@QueryParam("page") int page) {
        Gson gson = new Gson();
        String json;
        
        PagedHelper p = new PagedHelper();
       // if (size == 0) {
           // p.setList(list);
        //} else {
        if(page==0 || page<0 ){
        System.out.println(page+"AAA");
            p.setList(list.subList(0, 10));
            p.setNext("1");
            p.setPrev("0");

           // p.setPrev("prev url (from Paging Service)");
        }else if(page==1){
            p.setList(list.subList(10, 20));
            p.setNext("2");
            p.setPrev("1");
        }else if(page==2){
            p.setList(list.subList(20, 30));
            p.setNext("3");
            p.setPrev("1");
        }else if(page==3){
            p.setList(list.subList(30, 40));
            p.setNext("4");
            p.setPrev("2");
        }else if(page==4){
            p.setList(list.subList(40, 50));
            p.setNext("5");
            p.setPrev("3");
        }else if(page==5){
            p.setList(list.subList(50, 60));
            p.setNext("6");
            p.setPrev("4");
        }else if(page==6){
            p.setList(list.subList(60, 70));
            p.setNext("7");
            p.setPrev("5");
        }else if(page==7){
            p.setList(list.subList(70, 80));
            p.setNext("8");
            p.setPrev("6");
        }else if(page==8){
            p.setList(list.subList(80, 90));
            p.setNext("9");
            p.setPrev("7");

        }else if(page==9 || page>9){
            p.setList(list.subList(90, 100));
            p.setNext("9");
            p.setPrev("7");
        }


        
        json = gson.toJson(p, PagedHelper.class);
        
        return Response.ok(json).build();
    }
    //@GET
   // @Path("page")
   // @Path("{page : [0-9]+}")
   // @Path("{id: [0-9]+}")
//    public Response getList(@QueryParam("pack") int page) {
//        Gson gson = new Gson();
//        String json;
//        //$_GET['x'];
//
//        System.out.println("SSSSSS");
//        PagedHelper p = new PagedHelper();
//
//        //if (page == 0) {
//            //p.setList(list);
//        //} else {
//        //int i=Integer.valueOf(page);
//            p.setList(list.subList(0, 2));
//        //}
//
//        p.setNext("");
//        p.setPrev("prev url (from Paging Service)");
//
//        json = gson.toJson(p, PagedHelper.class);
//
//        return Response.ok(json).build();
//        //return Response.ok().build();
//
//    }
}
