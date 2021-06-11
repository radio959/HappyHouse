
<template>

  <div class="headerbar">
		<b-navbar toggleable="lg" type="light" variant="light">
			<b-navbar-brand href="/">
				<img src = "../../assets/logo.png" id="headerimg" width="40px" height="40px" >
			</b-navbar-brand>
			<b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
			<b-collapse id="nav-collapse" is-nav>
				
				<b-navbar-nav class="ms-auto" type="light" variant="light">
					<b-nav-item href="/boardlist"> 게시판</b-nav-item>
					<b-nav-item v-if="isLogin" href="http://localhost:8080/logout"> 로그아웃</b-nav-item>
					<b-nav-item v-else href="/login"> 로그인</b-nav-item>
					<b-nav-item-dropdown text="언어" right>
						<b-dropdown-item href="/">한국어</b-dropdown-item>
						<b-dropdown-item href="/EN">English</b-dropdown-item>
					</b-nav-item-dropdown>
				</b-navbar-nav>
			</b-collapse>
		</b-navbar>
	</div>

</template>
<script>
export default {
	data() {
		return {
			isLogin : this.logincheck()
		}
	},
	
	methods: {
		logincheck() {
			return sessionStorage.getItem("user") != null
		}
	},


}
</script>

<style>
	/* .navbar.navbar-dark.bg-dark{
		background-color: #ffffff!important;
		font-variant: normal;
	} */
	#headerimg{
		margin-left: 20px;
	}
	.headerbar{
		position: fixed;
		top: 0;
		left : 0;
		right : 0;
		z-index :99999
    /* position: relative; */
	}
	.ms-auto {
		margin-right: 50px;
	}
	.nav-link {
		vertical-align: auto;
	}
	/* .ms-auto>b-nav-item {
		margin-left: 10px;
		margin-right: 10px;
	} */

</style>

