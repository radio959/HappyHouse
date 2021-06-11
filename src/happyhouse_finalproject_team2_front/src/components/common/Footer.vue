<template>
	<footer>
		<b-row>
    <b-col>
      <br><br>
      <h2> JOIN US </h2> <br>
      <h6> project by Team 뀨우 </h6> <br>
      <h6> Tel : 010-1234-5678 </h6> <br>
      <h6> E-mail : kwjkw@ssafy.com </h6>
    </b-col>
    <b-col align-self="start">
      <br><br>
      <h2> RECOMMEND SITE </h2><br>
      <ul class="hyper">
        <li class="hyper"><a href = "https://land.naver.com/" target = "blank" > 네이버 부동산 </a></li>
        <li class="hyper"><a href = "https://www.dabangapp.com/" target = "blank" > 다방 </a></li>
        <li class="hyper"><a href = "https://www.zigbang.com/" target = "blank" > 직방 </a></li>
      </ul>
    </b-col>
    <b-col>
      <br><br>
      <h2> SNS </h2><br>
      <ul class="hyper">
        <li class="hyper">
          <a href="#"><b-img :src="require('@/images/link/instar.png')" width="50px" height="50px"/></a>
        </li>
        <li class="hyper">
          <a href="#"><b-img :src="require('@/images/link/github.png')" width="50px" height="50px"/></a>
        </li>
        <li class="hyper">
          <a href="#"><b-img :src="require('@/images/link/linkedin.png')" width="50px" height="50px"/></a>
        </li>
      </ul>
    </b-col>
  </b-row>
	</footer>
</template>

<script>
export default {
	
}
</script>

<style scoped>
footer{border-top:1px solid #35495e; text-align:center; font-size:16px; color:#41b883; margin:100px 0 0 0;}
.hyper {
  padding: 0 10;
  display: inline-block;
  margin:0 auto
}
</style>