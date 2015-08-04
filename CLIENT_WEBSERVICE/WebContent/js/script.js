function print(jsondata){
	var text = "";
	
	$.each(jsondata, function(key, value) {
		text += value.ID + " " + value.NAME + "<br>";
	});
	
	$("#out").append(text);
}

$(function(){
	$("#getdata").click(function(){
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/DEMO_WEBSERVICE/rest/demoservice/hello1",
			datatype: "json",
			success: function(jsondata) {
				print(jsondata);
			}
		});
	});
});