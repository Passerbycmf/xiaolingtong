package com.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Multimap;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2018/2/7.
 */
public class Cache {
    static Logger log = Logger.getLogger(Cache.class);
    //存放字典表
    public static Multimap<String, String[]> dictMap = null;
    //城市缓存
    public static HashMap<String, String> cityMap = null;
    //角色缓存
    public static HashMap<String, String> jsMap = null;
    public static LoadingCache<String, String> menCache = null;
    public static HashSet<String> xtcdSet = null;
    //快递公司缓存
    public static HashMap<String, String> disCompanyMap = null;
    //private static UpmsCityMapper upmsCityMapper;

    /*private static DictionaryMapper dictionaryMapper;
    private static CityMapper cityMapper;
    private static JsMapper jsMapper;
    private static TagMapper tagMapper;
    private static XtcdMapper xtcdMapper;
    private static Dis_companyMapper dis_companyMapper;*/
   /* static {
        upmsCityMapper = (UpmsCityMapper) SpringBeanUtil.getSpringBean("upmsCityMapper");
    }*/
    /*static {
        dictionaryMapper = (DictionaryMapper) SpringBeanUtil.getSpringBean("dictionaryMapper");
        cityMapper = (CityMapper) SpringBeanUtil.getSpringBean("cityMapper");
        jsMapper = (JsMapper) SpringBeanUtil.getSpringBean("jsMapper");
        tagMapper = (TagMapper) SpringBeanUtil.getSpringBean("tagMapper");
        xtcdMapper = (XtcdMapper) SpringBeanUtil.getSpringBean("xtcdMapper");
        dis_companyMapper = (Dis_companyMapper) SpringBeanUtil.getSpringBean("dis_companyMapper");
    }*/

    public static void LoadAll() {
        log.info("开始加载Cache-----------------------------");
        //initCityMap();
        //initDicMap();
        //initJsMap();
        //initXtcdSet();
        //initDisCompany();
    }

    private static void initMemCache() {
        menCache = CacheBuilder.newBuilder().maximumSize(10000).expireAfterWrite(60, TimeUnit.MINUTES).build(new CacheLoader<String, String>() {
            public String load(String key) throws Exception {
                return "0";
            }
        });
    }

    public static void initDicMap() {
       /* log.info("开始加载Dictionary-----------------------------");
        List<Dictionary> list = dictionaryMapper.findAll();
        if (list != null && list.size() > 0) {
            if (dictMap != null) {
                dictMap.clear();
            } else {
                dictMap = ArrayListMultimap.create();
            }
            for (Dictionary d : list) {
                HashMap<String, String> m = new HashMap<String, String>();
                log.info(d.getDicName() + " : " + d.getDicValue());
                dictMap.put(d.getDicType(), new String[]{d.getDicValue(), d.getDicName()});
            }
        }*/
    }

    //刷新城市缓存
    public static void initCityMap() {
//        log.info("开始加载City-----------------------------");
//        HashMap<String, String> map = new HashMap<>();
//        List<UpmsCity> list = upmsCityMapper.findAll(new HashMap<String, Object>());
//        if (list != null && list.size() > 0) {
//            for (UpmsCity city : list) {
//                map.put(String.valueOf(city.getId()), city.getCityName());
//            }
//            if (cityMap != null) {
//                cityMap.clear();
//            }
//            cityMap = map;
//        }
    }

    public static void initJsMap() {
        /*log.info("开始加载js-----------------------------");
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("sjid", 1);
        List<Js> list = jsMapper.findAll(paraMap);
        if (list != null && list.size() > 0) {
            for (Js js : list) {
                if (js.getId() == 2) {
                    continue;
                }
                map.put(String.valueOf(js.getId()), js.getMc());
            }
            if (jsMap != null) {
                jsMap.clear();
            }
            jsMap = map;
        }*/
    }

    public static void initXtcdSet() {
        /*log.info("开始加载xtcdSet-----------------------------");
        List<Xtcd> list = xtcdMapper.findAll();
        if (list != null) {
            xtcdSet = new HashSet<>();
            for (Xtcd x : list) {
                if (StringUtil.isNotEmpty(x.getUrl())) {
                    xtcdSet.add(x.getUrl());
                }
            }
        }*/
    }

    public static void initDisCompany() {
        /*log.info("开始加载disCompanyMap-----------------------------");
        disCompanyMap = new HashMap<>();
        List<Dis_company> list = dis_companyMapper.findAll();
        for (Dis_company d : list) {
            disCompanyMap.put(d.getCode(),d.getCompanyname());
            disCompanyMap.put(d.getCompanyname(),d.getCode());
        }*/
    }
}
