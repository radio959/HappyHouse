import Vue from "vue";
import VueRouter from "vue-router";
// import Home from "../components/Home.vue";

import BoardList from "../components/BoardList.vue";
import Login from "../components/Login.vue";
import English from "../components/English.vue";
import Main from "../components/Main.vue";
import Board from "../components/Board.vue";
import LoginProccess from "../components/LoginProcess.vue"
import LogoutProccess from "../components/LogoutProccess.vue"

Vue.use(VueRouter);

export default new VueRouter({
  mode: "history",
  routes: [
    { path: "/", component: Main },
    { path: "/main", component: Main },
    { path: "/boardlist", component: BoardList },
    { path: "/login", component: Login },
    { path: "/EN", component: English },
    { path: "/detail/:num", component: Board },
    { path: "/loginProccess", component: LoginProccess },
    { path: "/logoutProccess", component: LogoutProccess },

  ],
});

// const routes = [
//   {
//     path: "/",
//     component: Home,
//   },
//   {
//     path: "/announcement",
//     component: Announcement,
//   },
//   {
//     path: "/QnAlist",
//     component: QnAlist,
//   },
//   {
//     path: "/board",
//     component: Board,
//   },
//   {
//     path: "/login",
//     component: Login,
//   },
//   {
//     path: "/EN",
//     component: English,
//   },
// ];
