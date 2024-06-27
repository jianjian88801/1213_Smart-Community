import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import canyudajuan from '@/views/modules/canyudajuan/list'
    import news from '@/views/modules/news/list'
    import zhoubianfuwu from '@/views/modules/zhoubianfuwu/list'
    import zaixianbaoxiu from '@/views/modules/zaixianbaoxiu/list'
    import wenjuandiaocha from '@/views/modules/wenjuandiaocha/list'
    import aixinzhulao from '@/views/modules/aixinzhulao/list'
    import storeup from '@/views/modules/storeup/list'
    import tousujianyi from '@/views/modules/tousujianyi/list'
    import shequxinxi from '@/views/modules/shequxinxi/list'
    import cheweixinxi from '@/views/modules/cheweixinxi/list'
    import kehu from '@/views/modules/kehu/list'
    import discusszaixianbaoxiu from '@/views/modules/discusszaixianbaoxiu/list'
    import chat from '@/views/modules/chat/list'
    import messages from '@/views/modules/messages/list'
    import cheweizumai from '@/views/modules/cheweizumai/list'
    import config from '@/views/modules/config/list'
    import discusstousujianyi from '@/views/modules/discusstousujianyi/list'
    import discussshequxinxi from '@/views/modules/discussshequxinxi/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/canyudajuan',
        name: '参与答卷',
        component: canyudajuan
      }
      ,{
	path: '/news',
        name: '通知公告',
        component: news
      }
      ,{
	path: '/zhoubianfuwu',
        name: '周边服务',
        component: zhoubianfuwu
      }
      ,{
	path: '/zaixianbaoxiu',
        name: '在线报修',
        component: zaixianbaoxiu
      }
      ,{
	path: '/wenjuandiaocha',
        name: '问卷调查',
        component: wenjuandiaocha
      }
      ,{
	path: '/aixinzhulao',
        name: '爱心助老',
        component: aixinzhulao
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/tousujianyi',
        name: '投诉建议',
        component: tousujianyi
      }
      ,{
	path: '/shequxinxi',
        name: '社区信息',
        component: shequxinxi
      }
      ,{
	path: '/cheweixinxi',
        name: '车位信息',
        component: cheweixinxi
      }
      ,{
	path: '/kehu',
        name: '客户',
        component: kehu
      }
      ,{
	path: '/discusszaixianbaoxiu',
        name: '在线报修评论',
        component: discusszaixianbaoxiu
      }
      ,{
	path: '/chat',
        name: '客服中心',
        component: chat
      }
      ,{
	path: '/messages',
        name: '留言板管理',
        component: messages
      }
      ,{
	path: '/cheweizumai',
        name: '车位租买',
        component: cheweizumai
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/discusstousujianyi',
        name: '投诉建议评论',
        component: discusstousujianyi
      }
      ,{
	path: '/discussshequxinxi',
        name: '社区信息评论',
        component: discussshequxinxi
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
