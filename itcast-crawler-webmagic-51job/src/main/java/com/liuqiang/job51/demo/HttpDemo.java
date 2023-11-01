package com.liuqiang.job51.demo;

import cn.hutool.http.HttpUtil;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: TODO
 * @date 2023/10/7 15:27
 */
public class HttpDemo {
    public static void main(String[] args) {

        String Q_URL= "https://we.51job.com/api/job/search-pc?" +
                "api_key=51job&timestamp=1696663401&keyword=java&searchType=2" +
                "&function=&industry=&jobArea=000000&jobArea2=&landmark=&metro=&" +
                "salary=&workYear=&degree=&companyType=&companySize=&jobType=&issueDate=&" +
                "sortType=0&pageNum=1&requestId=&pageSize=20&source=1&accountId=231385641&pageCode=sou%7Csou%7Csoulb";

        String Y_URL = "https://we.51job.com/api/job/search-pc?" +
                "api_key=51job&timestamp=1696663401&keyword=java&searchType=2" +
                "&function=&industry=&jobArea=000000&jobArea2=&landmark=&metro=&" +
                "salary=&workYear=&degree=&companyType=&companySize=&jobType=&issueDate=&" +
                "sortType=0&pageNum=1&requestId=&pageSize=20&source=1&accountId=231385641&pageCode=sou%7Csou%7Csoulb";

        String H_URL = "https://we.51job.com/api/job/search-pc?" +
                "api_key=51job&timestamp=1696663401&keyword=java&searchType=2" +
                "&function=&industry=&jobArea=000000&jobArea2=&landmark=&metro=&" +
                "salary=&workYear=&degree=&companyType=&companySize=&jobType=&issueDate=&" +
                "sortType=0&pageNum=1&requestId=&pageSize=20&source=1&accountId=231385641&pageCode=sou%7Csou%7Csoulb" +
                "&u_atoken=58d617d4-f66c-4c17-afc2-c9bfbdc926cf&" +
                "u_asession=01D-MRSLDsP-ZxctBZAqk_Z_RODrb3HwUE3kZ0oUziZFVXChx8T55xOy9s338UH-lpe3hppV9mZrrfkgNIKpIZEdsq8AL43dpOnCClYrgFm6o&u_asig=" +
                "05_wGiXn1r33p7t7xy6IHKhSAwn4xzKLGi_eBFyy6kBr_VEiYxmCxbMoW9SL1RpfM0DA4k-_B3wZtFNDuPoPkib_7VDa-06fXovOVV23KWzFO9ElNfr1VODWFJarqOO0E4i8KAzGEjiLfabRhvJYLC__AfPq-xbCF1SKisVygo-sqy477fBC2m3X-uEydcauVRksmHjM0JOodanL5-M1Qs1fD8Zk1EigN-NVT-L4k8HGZ3tf1_DGASulORISvhrInR3PUdsh0Ce0PdkxR8mch-HZqRYtA7DyuGDsXl54ZAuxjY94r_LXIIil3Y3aVPRGAe&u_aref=zJSVcmSMzdtFeRBAd84x7XH%2FNgI%3D";


        String hao = HttpUtil.get("http://www.hao123.com");
        System.out.println(hao);
    }
}
