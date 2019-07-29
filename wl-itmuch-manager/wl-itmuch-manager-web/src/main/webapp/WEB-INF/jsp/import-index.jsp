<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<a class="easyui-linkbutton" onclick="importIndex()">一键导入商品数据到索引库</a>
</div>
<script type="text/javascript">
function importIndex() {  //改成 jsonp 请求
	/*$.post("http://localhost:8083/search/manager/impoart/all",function(data){
		if(data.status == 200){
			$.messager.alert('提示','导入索引库成功！！！！');
		}else{
			$.messager.alert('提示','导入索引库失败~~~~~');
		}
	}); */
	$.ajax({
		url:"http://localhost:8083/search/manager/impoart/all",
		dataType:"jsonp",
		data:{},
		Type:"get",
		success:function (data) {
			if (data.status ==200){
				$.messager.alert('提示','导入索引库成功！！');
			} else{
				$.messager.alert('提示','导入索引库失败~~~~');
			}
		},
		error:function (msg) {
			$.messager.alert('错误提示','ajax参数错误');
		}
	})
}
</script>