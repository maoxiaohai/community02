## 码匠社区项目




## 工具


**1.@RestController和@Controller之间的区别：** 

@RestController相当于@Controller加上@ResponseBody,也就是说@RestController将返回值进行格式转换，如果返回类型是String，将直接返回
其String数值，而不是某个HTML文件；
 