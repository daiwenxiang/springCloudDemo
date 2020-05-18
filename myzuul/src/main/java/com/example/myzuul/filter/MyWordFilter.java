package com.example.myzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyWordFilter extends ZuulFilter {

    public List<String> words = new ArrayList<String>();

    //初始化块
    {
        words.add("沙雕");
        words.add("草泥马");
    }

    //测试一下
    public static void main(String[] args) {
        MyWordFilter myWordFilter = new MyWordFilter();
        System.out.println(myWordFilter.wordFilter("你是个沙雕吗?草泥马草泥马!"));
    }

    public String wordFilter2(String param) {
        for (String word : words) {
            int index = param.indexOf(word);
            if (index != -1) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < word.length(); i++) {
                    sb.append("*");
                }
                param = param.replaceAll(word, sb.toString());
            }
        }
        return param;
    }

    //对输入的参数进行过滤
    public String wordFilter(String param) {
        //查看入参是否包含词库中的值
        for (String word : words) {
            int index = param.indexOf(word);
            while (index != -1) {
                //获得敏感词的长度
                int length = word.length();
                StringBuffer sb = new StringBuffer();
                sb.append(param.substring(0, index));
                //循环添加替换文本*号
                for (int i = 0; i < length; i++) {
                    sb.append("*");
                }
                //你是个沙雕(**)吗?
                //再追加后面一截
                sb.append(param.substring(index + length));
                //当前敏感词已经替换完成, 重新给param赋值
                param = sb.toString();
                index = param.indexOf(word);
            }
        }
        return param;
    }


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //先获得请求参数的Map集合
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, List<String>> parameterMap2 = new HashMap<>();

        for (String key : parameterMap.keySet()) {
            System.out.println("key = " + key);
            List<String> list = new ArrayList<>();

            //循环遍历每个key对应的值数据
            String[] values = parameterMap.get(key);
            for (int i = 0; i < values.length; i++) {
                //过滤敏感词
                list.add(wordFilter2(values[i]));
            }
            parameterMap2.put(key, list);
            context.setRequestQueryParams(parameterMap2);
        }
        return null;
    }
}
