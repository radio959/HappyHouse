<template>
  <div id="app">
    <!-- 추가된 헤더 컴포넌트 사용 -->
    <Header />
    
    <router-view></router-view>
	
    <!-- 추가된 풋터 컴포넌트 사용 -->
    <Footer />
  </div>
</template>


<script>
import Header from './components/common/Header'; //import 헤더 추가
// import Main from './components/Main.vue'; 
import Footer from './components/common/Footer'; //import 풋터 추가
export default {
  name: 'App',
  components: {
    Header          //헤더 컴포넌트 추가
    // ,Main
    ,Footer         //풋터 컴포넌트 추가
    
  }
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
