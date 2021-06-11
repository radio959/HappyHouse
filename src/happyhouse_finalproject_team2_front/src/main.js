import Vue from "vue";
import App from "./App.vue";
import router from "./js/router.js";
import store from "./js/store.js";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import { BootstrapVue, BootstrapVueIcons } from "bootstrap-vue";

Vue.use(BootstrapVueIcons);

Vue.config.productionTip = false;
Vue.use(BootstrapVue);


new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
