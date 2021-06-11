
<template>
<div>
  <b-card title="로그인" sub-title="1초면 간편하게! 로그인을 진행해보세요">
    <b-card-text>
            <a class="btn_social" @click="naverLogin"><b-img :src="require('@/images/login/naver_button.png')"/></a><br>
            <a class="btn_social" @click="kakaoLogin"><b-img :src="require('@/images/login/kakao_button.png')"/></a><br>
            <a class="btn_social" @click="googleLogin"><b-img :src="require('@/images/login/google_button.png')"/></a><br>
            <a class="btn_social" @click="facebookLogin"><b-img :src="require('@/images/login/facebook_button.png')"/></a><br>
    </b-card-text>
  </b-card>
</div>
</template>
<script>
    export default {
    created() {},
    computed: {},
     methods: {
         facebookLogin() {
            window.open("http://localhost:8080/oauth2/authorization/facebook");
         },
         kakaoLogin() {
            window.open("http://localhost:8080/oauth2/authorization/kakao");
         },

         googleLogin() {
            window.open("http://localhost:8080/oauth2/authorization/google");
         },
         naverLogin() {
            window.open("http://localhost:8080/oauth2/authorization/naver");
         },
     }
}
</script>
<style>
  #app{
    padding-top :65px;
  }
  .del {
		text-decoration: line-through;
	}
	ul {
		list-style-type: none;
		padding-left: 0px;
		margin-top: 0;
		text-align: left;
	}
	li {
		display: flex;
		min-height: 50px;
		height: 50px;
		line-height: 50px;
		margin: 0.5rem 0;
		padding: 0 0.9rem;
		background: white;
		border-radius: 5px;
	}
  .blsection{
    padding-top: 20px;
  }
	
	.list-enter-active,
	.list-leave-active {
		transition: all 1s;
	}
	.list-enter,
	.list-leave-to {
		opacity: 0;
		transform: translateY(30px);
	}
</style>
