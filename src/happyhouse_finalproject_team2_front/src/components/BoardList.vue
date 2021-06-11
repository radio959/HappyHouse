<template>
	<!-- <section class="blsection">
		<transition-group name="list" tag="ul">
			<li v-for="(board, index) in boardlist.content" :key="index" class="shadow" >
				<span @click="showBoard(board.id)">
					{{ board.id}}. {{ board.title }}
				</span>
			</li>
		</transition-group>
    <div class="mt-3">
      <b-pagination-nav number-of-pages="10" base-url="boardlist/"></b-pagination-nav>
    </div>
	</section> -->
  <div class="overflow-auto">
    

    <b-table
      id="my-table"
      hover
      :items="boardlist"
      @row-clicked="showBoard"
      :fields="column"
      :per-page="perPage"
      :current-page="currentPage"
      small
    >
    <template v-slot:cell(Delete)="data"> <!-- `data` -->
        <b-button variant="danger" v-on:click="deleteLog(data.item.log_id)">Delete</b-button>
    </template>
    </b-table>

    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="my-table"
    ></b-pagination>

  </div>
</template>

<script>
export default {
  created() {
			//store안의 actions 중 ALLTODO 호출해서 데이터 가져오라고 부탁
			this.$store.dispatch("ALLBOARD"); //ACTION CALL
      console.log(this.$store.state.boardlist);
      
      // console.log("board! "+this.$store.state.boardlist.board.id);
      
      // console.log("items.id! "+this.$store.state.boardlist.items.id);
      // console.log("이거 지우면 실행된다.");
      this.items = this.$store.state.boardlist;
	},
  data() {
      return {
        perPage: 10,
        currentPage: 1,
        items: [],
        // index: this.items.index,
        column: [
          {
            key: "id",
            label: "글 번호"
          },
          {
            key: "title",
            label: "글 제목"
          },

        ]
      }
    },
  computed: {
    rows() {
      return this.$store.state.boardlist.length;
    },
    boardlist() {
				console.log(this.$store.state.boardlist.length);
				return this.$store.state.boardlist;//data를 직접 접근
		},
  },
  methods: {
    showBoard(item) {
				//화면이 바뀌어야 함
        console.log(this.$store.state.boardlist.id);
				this.$router.push("/detail/"+item.id );
		},
  }
}
</script>

<style>
  .overflow-auto{
    padding-top :65px;
  }
  .del {
		text-decoration: line-through;
	}
	/* ul {
		list-style-type: none;
		padding-left: 0px;
		margin-top: 0;
		text-align: left;
	} */
	/* li {
		display: flex;
		min-height: 50px;
		height: 50px;
		line-height: 50px;
		margin: 0.5rem 0;
		padding: 0 0.9rem;
		background: white;
		border-radius: 5px;
	} */
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
  table {
  width: 100%;
  border-collapse: collapse;
  }
  table th {
    font-size: 1.2rem;
  }
  table tr {
    height: 2rem;
    text-align: center;
    border-bottom: 1px solid #505050;
  }
  table tr:first-of-type {
    border-top: 2px solid #404040;
  }
  table tr td {
    padding: 1rem 0;
    font-size: 1.1rem;
  }
  .btn-cover {
    margin-top: 1.5rem;
    text-align: center;
  }
  .btn-cover .page-btn {
    width: 5rem;
    height: 2rem;
    letter-spacing: 0.5px;
  }
  .btn-cover .page-count {
    padding: 0 1rem;
  }
  .page-item {
    padding: 0 0.2rem;
  }
</style>
