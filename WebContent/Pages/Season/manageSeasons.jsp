<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form action="saveSeason" id="createSeasonForm">
	<s:actionmessage />
	<s:actionerror />
	
	<s:textfield name="seasonVO.name" id="seasonName" key="season.name" />
	
	<s:textfield name="seasonVO.startDate" id="startDate" key="season.start.date" />
	<s:textfield name="seasonVO.endDate" id="endDate" key="season.end.date" />
	
	<s:hidden name="seasonVO.coachId" />
	<s:hidden name="seasonVO.seasonId" />
	
	<s:submit id="addSeasonLink" />
	<!--<s:a id="addSeasonLink" ><s:text name="season.add" /></s:a>-->
	
</s:form>

<table id="seasonsTable">
	<thead>
		<tr>
			<th><s:text name="season.name" /></th>
			<th><s:text name="season.start.date" /></th>
			<th><s:text name="season.end.date" /></th>
			<th><s:text name="season.actions" /></th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="seasons" >
			<s:url id="editSeasonURL" action="preSaveSeason">
				<s:param name="seasonId" value="seasonId" />
			</s:url>
			<s:url id="deleteSeasonURL" action="deleteSeason">
				<s:param name="seasonId" value="seasonId" />
			</s:url>
			<s:url id="planSeasonURL" action="planSeason">
				<s:param name="seasonId" value="seasonId" />
			</s:url>
					
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="startDate" /></td>
				<td><s:property value="endDate" /></td>
				<td>
					<a href="${editSeasonURL}" ><s:text name="season.edit" /></a>
					<a href="${deleteSeasonURL}" ><s:text name="season.delete" /></a>
					<a href="${planSeasonURL}" ><s:text name="season.plan" /></a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
	<tfoot></tfoot>
</table>

<script>
	jQuery(document).ready(function(){
		jQuery("#startDate").datepicker({
			numberOfMonths: 2,
			dateFormat: "dd/mm/yy",
			onSelect: function(selected) {
				jQuery("#endDate").datepicker("option","minDate", selected)
			}
		});
		jQuery("#endDate").datepicker({
			numberOfMonths: 2,
			dateFormat: "dd/mm/yy",
			onSelect: function(selected) {
				jQuery("#startDate").datepicker("option","maxDate", selected)
			}
		});
	});
</script>