
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

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

function changePhotosOnMainPage(prevevImg, initial){
	var randomImg = getRandomInt(1, 5);
	while(prevevImg == randomImg){
		randomImg = getRandomInt(1, 5);
	}
	var element = document.getElementById('main_gallery_img');
	if(initial){
		setTimeout(function(){element.src = "assets/photos/main_page/" + randomImg + ".jpg";}, 3500);
	}else{
		element.src = "assets/photos/main_page/" + randomImg + ".jpg";
	}
	setTimeout(function(){element.style.opacity = "0.9";}, 3000);
	setTimeout(function(){element.style.opacity = "0.8";}, 3100);
	setTimeout(function(){element.style.opacity = "0.7";}, 3200);
	setTimeout(function(){element.style.opacity = "0.6";}, 3300);
	setTimeout(function(){element.style.opacity = "0.5";}, 3400);
	setTimeout(function(){element.style.opacity = "0.4";}, 3480);
	setTimeout(function(){element.style.opacity = "0.5";}, 3560);
	setTimeout(function(){element.style.opacity = "0.6";}, 3600);
	setTimeout(function(){element.style.opacity = "0.7";}, 3700);
	setTimeout(function(){element.style.opacity = "0.8";}, 3800);
	setTimeout(function(){element.style.opacity = "0.9";}, 3900);
	setTimeout(function(){element.style.opacity = "1.0";}, 4000);
	setTimeout(function(){changePhotosOnMainPage(randomImg, false)}, 3500);
}