<template>
	<div class="boarddetail">
		<table>
			<tbody>
				<tr>
					<td>번호</td>
					<td>
						{{ board.id}}
					</td>
				</tr>
				<tr>
					<td> 제목 </td>
					<td>
						{{ board.title }}
					</td>
				</tr>
				<tr>
					<td>등록일</td>
					<td>
						{{ board.createdDate }}
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						{{ board.content }}
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</template>

<script>
	export default {
		created() {
			//action call
			var no = this.$route.params.num; //이전화면에서 파라메터 받아옴
			console.log(no);
			this.$store.dispatch("SHOWBOARD", { num: no });
		},
		computed: {
			board() {
        console.log("id는 "+this.$store.state.board.id);
				return this.$store.state.board;
			},
		},
	};
</script>

<style scoped>
  .boarddetail{
    padding-top:50px;
  }

	input:focus {
		outline: none;
	}
	.inputBox {
		background: white;
		height: 50px;
		line-height: 50px;
		border-radius: 5px;
	}
	.inputBox input {
		border-style: none;
		font-size: 0.9rem;
	}
	.addContainer {
		background: linear-gradient(to right, #6478fb, #8763fb);
		display: inline-block;
		width: 3rem;
		border-radius: 0 5px 5px 0;
	}

	.modifyBtn {
		color: white;
		vertical-align: middle;
	}

	table {
		margin: 10px auto;
		border-collapse: collapse;
		border: 2px solid #996;
		font: normal 90%/140% verdana, arial, helvetica, sans-serif;
		color: #333;
		background: #fffff0;
	}

	.caption {
		background-color: #222;
		vertical-align: middle;
		text-align: center;
		padding: 15px;
		font-size: 20px;
		color: #fff;
	}

	td,
	th {
		border: 1px solid #cc9;
		padding: 0.3em;
	}
	thead th,
	tfoot th {
		background-color: "#f5deb3";
		border: 1px solid #cc9;
		text-align: center;
		font-size: 1em;
		font-weight: bold;
		color: #444;
		background: #dbd9c0;
	}
	tbody td a {
		background: transparent;
		color: #72724c;
		text-decoration: none;
		border-bottom: 1px dotted #cc9;
	}
	tbody td a:hover {
		background: transparent;
		color: #666;
		border-bottom: 1px dotted #72724c;
	}
	tbody th a {
		background: transparent;
		color: #72724c;
		text-decoration: none;
		font-weight: bold;
		border-bottom: 1px dotted #cc9;
	}
	tbody th a:hover {
		background: transparent;
		color: #666;
		border-bottom: 1px dotted #72724c;
	}
	tbody th,
	tbody td {
		vertical-align: top;
		text-align: center;
	}
	tfoot td {
		border: 1px solid #996;
	}
	.odd {
		color: #333;
		background: #f7f5dc;
	}
	tbody tr:hover {
		color: #333;
		background: #fff;
	}
	tbody tr:hover th,
	tbody tr.odd:hover th {
		color: #333;
		background: #ddd59b;
	}

	tbody tr {
		height: 50px;
		line-height: 50px;
	}
	ul {
		padding: 22px 50px 50px 490px;
		width: 940px;
		list-style: none;
	}
	#gnb li {
		display: inline;
	}
	#gnb li a {
		display: inline-block;
		background: #222;
		color: #fff;
		width: 150px;
		height: 23px;
		padding-top: 3px;
		text-align: center;
	}
	#gnb li a:hover {
		background: #900;
	}
</style>
