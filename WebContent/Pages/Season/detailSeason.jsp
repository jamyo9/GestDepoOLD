<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,java.text.*" %>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/FullCalendar/fullcalendar.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/FullCalendar/fullcalendar.print.css" media="print">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/TimePicker/jquery.timepicker.css">

<script type="text/javascript" src="<%=request.getContextPath()%>/js/libs/fullcalendar.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/libs/lang-all.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/libs/jquery.timepicker.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/libs/datepair.js" ></script>
		

<h2>
	<s:property value="seasonVO.name" />
</h2>

<s:property value="seasonVO.startDate" /> - <s:property value="seasonVO.endDate" />

<div id="calendar"></div>

<div id="newEvent" style="display: none;">
	<s:form action="saveEvent" id="saveEvent">
		<s:actionmessage />
		<s:actionerror />
		
		<s:hidden name="seasonId" id="seasonId" />
		<s:hidden name="eventId" id="eventId" />
		
		<s:hidden name="datePicked" id="datePicked" />
		
		<s:textfield id="title" name="title" key="create.event.title" />
		
		<p id="datepair">
			<s:textfield id="startEventDate" name="start" cssClass="time start" key="create.event.start.date" />
			<s:textfield id="endEventDate" name="end" cssClass="time end" key="create.event.end.date" />
		</p>
		
		<input type="radio" name="eventType" value="1" id="eventTypeTraining" >
		<label for="eventTypeTraining">Training</label>
		<input type="radio" name="eventType" value="2" id="eventTypeGame" >
		<label for="eventTypeGame">Game</label>
		
		
		<s:submit />
	</s:form>
</div>

<script>
	jQuery(document).ready(function() {
		jQuery('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			defaultDate: new Date(<s:property value="currentDate" />),
			defaultView: 'month',
			editable: true,
			// will hide Saturdays and Sundays
			weekends: true,
			 // allow "more" link when too many events
			eventLimit: true,
			lang: 'en',
			weekNumbers: true,
			events: [
				<c:forEach var='event' items='${events}'>
					{ id:'${event.eventId}', title: '${event.title}', start: new Date(${event.start}), end: new Date(${event.end}), editable: true },
				</c:forEach>
			],
			dayClick: function(date, jsEvent, view) {
				//alert('Clicked on: ' + date.format());
				var dateVar = new Date(date.format());
				jQuery("#datePicked").attr("value", dateVar.getTime());
				/*
				jQuery('#datepair .time').timepicker({
			        'showDuration': true,
			        'timeFormat': 'g:ia'
			    });
			    // initialize datepair
			    jQuery('#datepair').datepair();
			    */
				
			    jQuery('input#startEventDate').timepicker();
				jQuery('input#endEventDate').timepicker();
				jQuery('#newEvent').dialog();
			},
			eventClick: function(event) {
		        alert(this.id);
			}
		})
		
		jQuery("#saveEvent").submit(function() {
			var formData = jQuery("#saveEvent").serializeArray();
			//alert(formData);
			jQuery.ajax({
				type: "POST",
				url: jQuery("#saveEvent").attr("action"),
				data: formData, // serializes the form's elements.
				success: function(data) {
					//alert("Success: " + data.eventoVO); // show response from the script.
					
					var source = { title: '${data.title}', start: new Date(${data.start}), end: new Date(${data.end}) };
					alert(source);
					
					jQuery('#calendar').fullCalendar('addEventSource', source);
						
					//jQuery('#saveEvent')[0].reset(); // Clean the form fields
					jQuery("#newEvent").dialog("close");
				},
				error: function(data) {
					alert("Error: " + data);
				}
			});
			return false; // avoid to execute the actual submit of the form.
		});
		
		/*
		jQuery.fn.serializeObject = function() {
			var output = {};
			//var fields = jQuery("#saveEvent").serializeArray();
			var fields = JSON.stringify(jQuery("#saveEvent").serializeArray());
			jQuery.each(fields, function(i, field) {
				if (output[field.name] !== undefined) {
					if (!output[field.name].push) {
						output[field.name] = [output[field.name]];
					}
					output[field.name].push(field.value || '');
				} else {
					output[field.name] = field.value || '';
				}
			});
			return output;
		};
		*/
	});

</script>
