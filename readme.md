# 用于封装一些api到jietpack
发布教程：https://blog.csdn.net/loutengyuan/article/details/145938967
# 模块说明
. api_amap_locsearch，api_amap_3dnav: 因为高德没有不包含地图的定位sdk合包的依赖，所以自己下载它的sdk包后拆分后传到jitpack，然后在uniapp的uts插件中引用，这样可以减少插件的体积。
. api_utils: 一些原生api，在uts上无法调用或者调用起来不方便，例如在uts上用Dialog就会涉及到theme问题，导致编译不成功。