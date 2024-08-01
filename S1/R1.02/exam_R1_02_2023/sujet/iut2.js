let params = new URLSearchParams(window.location.search),
  hideControls = params.get("hideControls") !== null;

document.getElementById("toggle-menu").addEventListener("click", (e) => {
  e.preventDefault();
  document.body.classList.toggle("menu-open");
});
//
//document
//  .getElementById("expand-collapse-btn")
//  .addEventListener("click", (e) => {
//    e.preventDefault();
//    document.body.querySelector("main").classList.toggle("condensed");
//  });
//
document.querySelector(".overlay").addEventListener("click", (e) => {
  e.preventDefault();
  document.body.classList.remove("menu-open");
});

hljs.highlightAll();
hljs.initLineNumbersOnLoad();

if (hideControls) {
  document.body.classList.add("print");

  let article = document.querySelector("article"),
    div = document.createElement("div");

  div.classList.add("a4");

  let tempNode = document.createElement("div");

  for (let i = article.childNodes.length - 1; i >= 0; i--) {
    tempNode.prepend(article.childNodes[i]);
  }

  article.append(div);
  let j = 0;
  while (tempNode.childNodes.length && j < 10000) {
    j++;

    let child = tempNode.childNodes[0];

    div.append(child);

    if (div.offsetHeight > 1123) {
      // 29.7cm
      div = document.createElement("div");
      console.log(child);
      div.classList.add("a4");
      article.append(div);
      div.append(child);
    }
  }
  article.childNodes.forEach((node) => node.classList.add("hide"));
  article.childNodes[0].classList.remove("hide");
  article.childNodes[0].classList.add("current");

  document.body.addEventListener("keydown", (e) => {
    if (e.key === "ArrowRight" || e.key === "n") {
      // Arrow right
      let current = document.querySelector("article > div.current"),
        next = current.nextElementSibling;

      if (!next) return;

      current.classList.remove("current");
      current.classList.add("hide");
      next.classList.remove("hide");
      next.classList.add("current");
    } else if (e.key === "ArrowLeft" || e.key === "p") {
      // Arrow left
      let current = document.querySelector("article > div.current"),
        prev = current.previousElementSibling;

      if (!prev) return;

      current.classList.remove("current");
      current.classList.add("hide");
      prev.classList.remove("hide");
      prev.classList.add("current");
    }
  });
}

document.querySelectorAll("span code").forEach((inline) => {
  hljs.highlightElement(inline);
});

//
//if (hideControls) {
//  document.body.classList.add("print");
//
//  let article = document.querySelector("article"),
//    div = document.createElement("div");
//
//  let tempNode = document.createElement("div");
//
//  for (let i = article.childNodes.length - 1; i >= 0; i--) {
//    tempNode.prepend(article.childNodes[i]);
//  }
//
//  article.append(div);
//  let j = 0;
//  while (tempNode.childNodes.length && j < 10000) {
//    j++;
//
//    let child = tempNode.childNodes[0];
//
//    div.append(child);
//
//    if (div.offsetHeight > 1123) {
//      // 29.7cm
//      div = document.createElement("div");
//      article.append(div);
//      div.append(child);
//    }
//  }
//  article.childNodes.forEach((node) => node.classList.add("hide"));
//  article.childNodes[0].classList.add("current");
//
//  document.body.addEventListener("keydown", (e) => {
//    if (e.key === "ArrowRight" || e.key === "n") {
//      // Arrow right
//      let current = document.querySelector("article > div.current"),
//        next = current.nextElementSibling;
//
//      if (!next) return;
//
//      current.classList.remove("current");
//      current.classList.add("hide");
//      next.classList.remove("hide");
//      next.classList.add("current");
//    } else if (e.key === "ArrowLeft" || e.key === "p") {
//      // Arrow left
//      let current = document.querySelector("article > div.current"),
//        prev = current.previousElementSibling;
//
//      if (!prev) return;
//
//      current.classList.remove("current");
//      current.classList.add("hide");
//      prev.classList.remove("hide");
//      prev.classList.add("current");
//    }
//  });
//}
//
let aside = document.querySelector("aside"),
  menu = aside.querySelector("ul");

document.querySelectorAll("article h2").forEach((title, i) => {
  let li = document.createElement("li"),
    a = document.createElement("a");

  if (!i) li.classList.add("active");

  //let t = title.innerText.replaceAll(" ", "-");
  let t = slugify(title.innerText);
  a.href = "#" + t;

  title.id = t;

  a.append(document.createTextNode(i + 1 + ". " + title.innerHTML));
  li.append(a);
  menu.append(li);
});

let onTop = true;

let updateMenu = function (scrollTop, offsetHeight) {
  let titles = document.querySelectorAll("article h2"),
    padding = 40; // top padding above the article
  let n = 0; // the index of the title found

  for (let i = titles.length - 1; i >= 0; i--) {
    // Check if the last title is visible
    let title = titles[i],
      isBelow = title.offsetTop > offsetHeight + scrollTop - 2 * padding;

    if (isBelow)
      // we continue
      continue;
    else {
      n = i;
      break;
    }
  }
  if (n > 0) {
    for (let i = n - 1; i >= 0; i--) {
      let title = titles[i],
        isVisible =
          title.offsetTop + title.offsetHeight - scrollTop + padding > 0;
      if (isVisible) n = i;
    }
  }

  document.querySelectorAll("aside ul li").forEach((li, i) => {
    if (i !== n) li.classList.remove("active");
    else li.classList.add("active");
  });
};

let main = document.querySelector("main");

main.addEventListener("scroll", (e) => {
  let { target } = e,
    { scrollTop, offsetHeight } = target;

  if (onTop && scrollTop > 50) {
    onTop = !onTop;
    document.body.classList.add("small-title");
  } else if (!onTop && scrollTop <= 50) {
    onTop = !onTop;
    document.body.classList.remove("small-title");
  }

  updateMenu(scrollTop, offsetHeight);
});

document.querySelectorAll("aside ul li a").forEach((a) => {
  let padding = 40;
  a.addEventListener("click", (e) => {
    let hashTagPosition = a.href.lastIndexOf("#"),
      id = a.href.substring(hashTagPosition + 1);

    let title = document.getElementById(id);
    if (title) {
      main.scrollTo({
        top: title.offsetTop + padding,
        behavior: "smooth",
      });
    }
    e.preventDefault();
  });
});

function slugify(str) {
  str = str.replace(/^\s+|\s+$/g, ""); // trim
  str = str.toLowerCase();

  // remove accents, swap ñ for n, etc
  var from = "ãàáäâáº½èéëêìíïîõòóöôùúüûñç·/_,:;";
  var to = "aaaaaeeeeeiiiiooooouuuunc------";
  for (var i = 0, l = from.length; i < l; i++) {
    str = str.replace(new RegExp(from.charAt(i), "g"), to.charAt(i));
  }

  str = str
    .replace(/[^a-z0-9 -]/g, "") // remove invalid chars
    .replace(/\s+/g, "-") // collapse whitespace and replace by -
    .replace(/-+/g, "-"); // collapse dashes

  return str;
}

(() => {
  const checkboxes = document.querySelectorAll('article label input[type="checkbox"]');
  let values = new Array(checkboxes.length).fill(0);
  if (localStorage.getItem('values')) {
    values = JSON.parse(localStorage.getItem('values'));
  }
  for (let i = 0; i < checkboxes.length; i++) {
    if (parseInt(values[i]) === 1) {
      checkboxes[i].checked = true;
    }
  };
  checkboxes.forEach((checkbox, i) => {
    checkbox.addEventListener('change', (e) => {
      values[i] = (checkbox.checked) ? 1 : 0;
      localStorage.setItem('values', JSON.stringify(values));
    });
  });
})();
