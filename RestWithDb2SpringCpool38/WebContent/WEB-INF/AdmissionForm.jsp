<html>
<body>
	<h1>${HeaderMessage}</h1>
	<h2>Student Admission Form For BSC</h2>
	<form action="/FirstSpringMVCProject/submitAdmissionForm.html" method="post">
		<table>
			<tr>
				<td>Student Name:</td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			
			<tr>
				<td>Student Age:</td>
				<td><input type="text" name="studentAge" /></td>
			</tr>

			<tr>
				<td>Student Contact No.:</td>
				<td><input type="text" name="studentContact" /></td>
			</tr>
			
			<tr>
				<td>Student DOB:</td>
				<td><input type="text" name="studentDob" /></td>
			</tr>
					
			<tr>
				<td>Student Skill Set:</td>
				<td>
					<select name="studentSkills" multiple>
						<option value="Core Java">Core Java</option>
						<option value="Java Script">Java Script</option>
						<option value="HTML">HTML</option>
					</select>
				
				</td>
			</tr>
			
		</table>

		<input type="submit" value="Submit" />
			
	</form>
</body>
</html>