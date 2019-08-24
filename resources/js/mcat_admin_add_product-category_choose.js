function categoryChange(e) {
  var food = ["건식사료", "습식사료", "우유/분유", "저칼로리사료"];
  var snack = ["캔", "소시지/건어물", "스낵", "츄르"];
  var toilet = ["응고형 모래", "흡수형 모래", "평판 화장실", "후드형 화장실"];
  var toy = ["낚시대/막대", "쿠션/공", "캣닢/인형", "레이저"];
  var living_goods = ["유모차", "이동가방", "급수기", "하우스"];
  var acc = ["목줄/가슴줄", "목걸이", "티셔츠", "원피스"];
  var clean_goods = ["모래삽", "브러쉬", "샴푸/린스", "발/발톱관리"];
  var default_option = ["2차 카테고리"];

  var target = document.getElementById("second_category");

  if (e.value == "0") var depth_2 = default_option;
  else if (e.value == "1") var depth_2 = food;
  else if (e.value == "2") var depth_2 = snack;
  else if (e.value == "3") var depth_2 = toilet;
  else if (e.value == "4") var depth_2 = toy;
  else if (e.value == "5") var depth_2 = living_goods;
  else if (e.value == "6") var depth_2 = acc;
  else if (e.value == "7") var depth_2 = clean_goods;
  
  target.options.length = 0;

  for (x in depth_2) {
      var opt = document.createElement("option");
      opt.value = depth_2[x];
      opt.innerHTML = depth_2[x];
      target.appendChild(opt);
  }
}
