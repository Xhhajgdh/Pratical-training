import { createApp } from 'vue'  //导入构建前端框架的入口
import App from './App.vue' // 这个是带入构建前端框架的一个实例
import router from './router' // 构建前端页面的路由，方便的管理前端页面组合
import store from './store' // 前端临时使用的数据库。用于存放一些轻量级的数据
import 'element-plus/dist/index.css' // 前端的页面模板
import ElementPlus from 'element-plus' //前端组件的一些模板
import './assets/css/global.css' //定义全局的页面属性，包括排版以及一切其他
createApp(App).use(store).use(router).use(ElementPlus,{size:'mini'}).mount('#app')  //启动主页面，并且使用定义过的相关配置