/**
 * 
 */
var popup = document.getElementById("transfer-popup");

function preloadPopup(id, name, path) {
	console.log("Yay");
	document.getElementById("user_name").innerHTML = name;
	document.getElementById("0912").innerHTML = `<form method="post"
					action="${path}/adminDashboardController?action=ADD_BALANCE&id=${id}" style="padding:30px;">
					<div class="input-field">
						<input type="text" name="amount" required> <label for="">Amount</label>
					</div>
					<div class="input-field">
						<input type="password" name="password" required> <label
							for="">Password</label>
					</div>
					<button type="submit" class="btn btn-primary">Confirm</button>
				</form>`;
	togglePopup(false);
}
function togglePopup(hide) {
	if(hide==false) {
		popup.classList.remove("hide");
	} else {
		popup.classList.add("hide");
	}
}