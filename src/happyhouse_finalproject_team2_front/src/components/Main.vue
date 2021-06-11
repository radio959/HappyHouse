<template>
  <div class="body">
    <b-carousel
      id="carousel-fade"
      style="text-shadow: 0px 0px 2px #000"
      fade
      :interval="4000"
      img-width="1024"
      img-height="480"
    >
      <b-carousel-slide
        caption="화려한 도심의 집"
        :img-src="require('@/images/house/seoul.jpg')"
      ></b-carousel-slide>
      <b-carousel-slide
        caption="자연과 맞닿은 집"
        :img-src="require('@/images/house/park.jpg')"
      ></b-carousel-slide>
      <b-carousel-slide
        caption="포근하고 아늑한 집"
        :img-src="require('@/images/house/house.jpg')"
      ></b-carousel-slide>
    </b-carousel>
    <br><br><br>
    <h2>내 집을 마련할 위치를 검색해보세요</h2>
    <br><br>
    <div>
      <b-form-select @change="inputSido">
        <b-form-select-option v-for="(sido, index) in sidolist" :key="index" :value="sido.sidoCode">{{sido.sidoName}}</b-form-select-option>
      </b-form-select> &nbsp;

      <b-form-select @change="inputGugun">
        <b-form-select-option v-for="(gugun, index) in gugunlist" :key="index" :value="gugun.gugunCode">{{gugun.gugunName}}</b-form-select-option>  
      </b-form-select> &nbsp;

      <b-form-select>
        <b-form-select-option v-for="(dong, index) in donglist" :key="index" >{{dong.dong}}</b-form-select-option>  
      </b-form-select> &nbsp;

      <b-button variant="outline-primary">검색</b-button>
    </div>
    <br><br><br>
    <h1>  </h1>
  </div>
</template>
<script>
  export default {
    methods: {
      inputSido(value) {
        console.log("함수 호출합니다!");
        console.log(value);
        if(value !="") {
          this.$store.dispatch("ALLGUGUN",value);
        }else alert ("시/도를 먼저 선택해주세요.");
      },
      inputGugun(value) {
        console.log("함수 호출합니다!");
        console.log(value);
        if(value !="") {
          this.$store.dispatch("ALLDONG",value);
        }else alert ("구/군을 먼저 선택해주세요.");
      }
    },
    created(){
      this.$store.dispatch("ALLSIDO");        
    },
    computed: {
      sidolist() {
        console.log(this.$store.state.sidolist.length);
        return this.$store.state.sidolist;
      },
      gugunlist() {
        console.log(this.$store.state.gugunlist.length);
        return this.$store.state.gugunlist;
      },
      donglist() {
        console.log(this.$store.state.donglist.length);
        return this.$store.state.donglist;
      }
    }
  }
</script>
<style scoped>
  .body{
    padding-top :0px;
  }
</style>