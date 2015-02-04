
var subMenuIds = {'menu_item_container03' : ['sub_menu_item_container03_01', 'sub_menu_item_container03_02']}

function movemenu (currentItemId) {
	var ids = subMenuIds[currentItemId];
	for (i = 0; i < ids.length; i++){
		var el = document.getElementById(ids[i]);
		if(el.style.visibility === 'visible'){
			el.style.position = 'absolute';
			el.style.visibility = 'hidden';
		}else {
			el.style.position = 'relative';
			el.style.visibility = 'visible';
		}
	}
} 