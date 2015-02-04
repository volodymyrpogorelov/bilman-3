
var direction = 1;
var DEFAULT_MARGIN_TOP = '4%';
var DISTANCE = 20;
function movemenu (currentItemId, nextItemId) {
	var el = document.getElementById(nextItemId);
	if(direction > 0){
		el.style.marginTop = ' ' + 2*DISTANCE + '%';
	}else{
		el.style.marginTop = DEFAULT_MARGIN_TOP;
	}
	direction*=-1;
}