document.getElementById("button").addEventListener("click", addItem);;

function addItem() {
  let input = document.getElementById("input").value;
  let list = document.getElementById("list");
  if (input.trim() === "") {
    alert("Please provise the valid input");
    return;
  }

  let newItem = document.createElement("li");
  newItem.style.color = "black";
  newItem.innerHTML = input;
//   newItem.classList.add("text");

  let currentItems = document.getElementById("list").getElementsByTagName("li");
  console.log(currentItems);
  let itemCount = currentItems.length;
  if ((itemCount + 1) % 3 === 0) {
    newItem.style.color = "red";
  }
  list.append(newItem);
  document.getElementById("input").value = "";
};
