import Vue from "vue";
import Vuex from "vuex";
import axios from "./axios-common.js";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {

    sidolist: [],
    gugunlist: [],
    donglist: [],
    boardlist: [],
    board: [],
    isLogin: false,
    // qnalist: [],
  },
  actions: {
    ALLSIDO: (store) => {
      axios
        .get("/api/v1/sido")
        .then((response) => {
          store.commit("ALLSIDO", { sidolist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },
    ALLGUGUN: (store, payload) => {
      axios
        .get("/api/v1/gungun/" + payload)
        .then((response) => {
          store.commit("ALLGUGUN", { gugunlist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },
    ALLDONG: (store, payload) => {
      axios
        .get("/api/v1/dong/" + payload)
        .then((response) => {
          store.commit("ALLDONG", { donglist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },
    ALLBOARD: (store) => {
      axios
        .get("/api/v1/boards?type=자유게시판")
        .then((response) => {
          store.commit("ALLBOARD", { boardlist: response.data });
          // console.log("store에서 찍은 로그 " + this.boardlist);
        })
        .catch((response) => {
          console.log(response);
        });
    },
    PAGEBOARD: (store, payload) => {
      console.log("페이지 번호일 겁니다." + payload);
      axios
        .get("/api/v1/boards?type=자유게시판&size=10&page=" + payload)
        .then((response) => {
          store.commit("PAGEBOARD", { boardlist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },
    SHOWBOARD: (store, payload) => {
      console.log("넘버는" + payload.num);
      axios
        .get("/api/v1/boards/" + payload.num)
        .then((response) => {
          console.log("조회 처리하였습니다.");
          store.commit("SHOWBOARD", { board: response.data }); //call mutation
        })
        .catch((exp) => alert("조회 처리에 실패하였습니다." + exp));
    },
    ADDBOARD: (store, payload) => {
      //console.log(payload);
      axios
        .post("/api/v1/boards/", { content: payload })
        .then(() => {
          console.log("추가 처리하였습니다.");
          store.dispatch("ALLBOARD"); //call action
        })
        .catch((exp) => alert("추가 처리에 실패하였습니다." + exp));
    },
    DELETEBOARD: (store, payload) => {
      axios
        .delete("/api/v1/boards/" + payload)
        .then(() => {
          console.log("삭제 성공!");
          store.dispatch("ALLBOARD");
        })
        .catch((response) => {
          console.log(response);
        });
    },

    COMPLETEBOARD: (store, payload) => {
      axios
        .put("/api/v1/boards/" + payload)
        .then(() => {
          console.log("완료 처리하였습니다.");
          store.dispatch("ALLBOARD"); //call action
        })
        .catch((exp) => alert("완료 처리에 실패하였습니다." + exp));
    },
  },
  mutations: {
    ALLSIDO: (state, payload) => {
      console.log(payload);
      state.sidolist = payload.sidolist;
    },
    ALLGUGUN: (state, payload) => {
      console.log(payload);
      state.gugunlist = payload.gugunlist;
    },
    ALLDONG: (state, payload) => {
      console.log(payload);
      state.donglist = payload.donglist;
    },
    ALLBOARD: (state, payload) => {
      console.log("뮤테이션 ALLBOARD 의 페이로드입니다." + payload);
      state.boardlist = payload.boardlist;
    },
    PAGEBOARD: (state, payload) => {
      console.log("뮤테이션 PAGEBOARD의 페이로드입니다." + payload);
      state.boardlist = payload.boardlist;
    },
    SHOWBOARD: (state, payload) => {
      state.board = payload.board;
    },
    LOGIN: (state) => {
      state.isLogin = true;
    },
    LOGOUT: (state) => {
      state.isLogin = false;
    },
  },
  getters: {
    loginstate(state) {
      return state.isLogin;
    }
  }
});
