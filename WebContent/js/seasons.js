// AN INITIAL WAY TO TRY TO ADD AJAX TO SAVE A SEASON.
jQuery(document).ready(function() {
	jQuery('#addSeasonLink').click(function(event) {
		var seasonForm = jQuery("form#saveSeasonForm");
		jQuery.getJSON(this.form.action, {
			
		}, function(jsonResponse) {
			var season = jsonResponse.addedSeasonVO;
			jQuery("#seasonsTable tr:last").after("<tr><td>" + season.name + "</td><td>" + season.startDate + "</td><td>" + season.endDate + "</td><td></td></tr>");
			//jQuery("#seasonsTable tr:last").after("<tr><td>" + res.data[i].name + "</td><td>" + res.data[i].startDate + "</td><td>" + res.data[i].endDate + "</td><td></td></tr>");
		});
	});
});