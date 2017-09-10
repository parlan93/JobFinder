$(document).ready(function(){
	// MOBIE NAVIGATION
	mobileNav();
	showRegisterForm();
	addSchoolField();
	addExperienceField();
	addSkillField();
	addLanguageField();
	addInterestField();
});

// MOBILE NAVIGATION
function mobileNav(){
	$('#mobile-nav-icon').bind('click', function(event){
		event.preventDefault();
		$('#mobile-nav').show(400);
	});
	$('#mobile-nav-close').bind('click', function(event){
		event.preventDefault();
		$('#mobile-nav').hide(400);
	});
}

// REGISTER FORM
function showRegisterForm(){
	$('#btn-register').bind('click', function(event){
		event.preventDefault();
		$('#btn-register').hide(400);
		$('#register-panel').removeClass('separator-bottom');
		$('#register-panel').addClass('no-padding-bottom');
		$('#register-form-wrapper').show(400);
	});
}

// CV - ADD SCHOOL FIELDs
function addSchoolField() {
	var max = 3;
	var container = $('#schools');
	var exists = $('.school').length;
	var id = 0;
	$('#btn-add-school').click(function(event) {
		event.preventDefault();
		if (exists < max) {
			id++;
			if (exists % 2) { 
				exists++;
				$(container).append('<div class="row school even"> <div class="col-xs-12 col-sm-8"> <div class="form-group"> <label for="education-school-' + id + '" class="input-label">Szkoła / Uczelnia</label> <input type="text" name="education-school[]" id="education-school-' + id + '" class="form-control input" placeholder="Nazwa szkoły / uczelni"> </div> </div> <div class="col-xs-12 col-sm-4"> <div class="form-group"> <label for="education-subject-' + id + '" class="input-label">Profil / Kierunek</label> <input type="text" name="education-subject[]" id="education-subject-' + id + '" class="form-control input" placeholder="Profil / Kierunek"> </div> </div> <div class="col-xs-12 col-sm-6"> <div class="form-group"> <label class="input-label">Początek</label> <div class="row"> <div class="col-xs-8 col-no-space"> <div class="form-group"> <label for="education-beginning-month-' + id + '" class="input-label input-label-second">Miesiąc</label> <select id="education-beginning-month-' + id + '" class="form-control input select" name="education-beginning-month[]"> <option value="October">Październik</option> </select> </div> </div> <div class="col-xs-4 col-no-space"> <div class="form-group"> <label for="education-beginning-year-' + id + '" class="input-label input-label-second">Rok</label> <select id="education-beginning-year-' + id + '" class="form-control input select input-middle" name="education-beginning-year[]"> <option value="2013">2013</option> </select> </div> </div> </div> </div> </div> <div class="col-xs-12 col-sm-6"> <div class="form-group"> <label class="input-label">Koniec</label> <div class="row"> <div class="col-xs-8 col-no-space"> <div class="form-group"> <label for="education-end-month-' + id + '" class="input-label input-label-second">Miesiąc</label> <select id="education-end-month-' + id + '" class="form-control input select" name="education-end-month[]"> <option value="October">Październik</option> </select> </div> </div> <div class="col-xs-4 col-no-space"> <div class="form-group"> <label for="education-end-year-' + id + '" class="input-label input-label-second">Rok</label> <select id="education-end-year-' + id + '" class="form-control input select input-middle" name="education-end-year[]"> <option value="2013">2013</option> </select> </div> </div> </div> </div> </div> <div class="col-xs-12"> <a href="#" class="btn btn-default btn-minus pull-right btn-delete-school"><i class="fa fa-trash" aria-hidden="true"></i> Usuń</a> </div> </div>');
			}
			else { 
				exists++;
				$(container).append('<div class="row school"> <div class="col-xs-12 col-sm-8"> <div class="form-group"> <label for="education-school-' + id + '" class="input-label">Szkoła / Uczelnia</label> <input type="text" name="education-school[]" id="education-school-' + id + '" class="form-control input" placeholder="Nazwa szkoły / uczelni"> </div> </div> <div class="col-xs-12 col-sm-4"> <div class="form-group"> <label for="education-subject-' + id + '" class="input-label">Profil / Kierunek</label> <input type="text" name="education-subject[]" id="education-subject-' + id + '" class="form-control input" placeholder="Profil / Kierunek"> </div> </div> <div class="col-xs-12 col-sm-6"> <div class="form-group"> <label class="input-label">Początek</label> <div class="row"> <div class="col-xs-8 col-no-space"> <div class="form-group"> <label for="education-beginning-month-' + id + '" class="input-label input-label-second">Miesiąc</label> <select id="education-beginning-month-' + id + '" class="form-control input select" name="education-beginning-month[]"> <option value="October">Październik</option> </select> </div> </div> <div class="col-xs-4 col-no-space"> <div class="form-group"> <label for="education-beginning-year-' + id + '" class="input-label input-label-second">Rok</label> <select id="education-beginning-year-' + id + '" class="form-control input select input-middle" name="education-beginning-year[]"> <option value="2013">2013</option> </select> </div> </div> </div> </div> </div> <div class="col-xs-12 col-sm-6"> <div class="form-group"> <label class="input-label">Koniec</label> <div class="row"> <div class="col-xs-8 col-no-space"> <div class="form-group"> <label for="education-end-month-' + id + '" class="input-label input-label-second">Miesiąc</label> <select id="education-end-month-' + id + '" class="form-control input select" name="education-end-month[]"> <option value="October">Październik</option> </select> </div> </div> <div class="col-xs-4 col-no-space"> <div class="form-group"> <label for="education-end-year-' + id + '" class="input-label input-label-second">Rok</label> <select id="education-end-year-' + id + '" class="form-control input select input-middle" name="education-end-year[]"> <option value="2013">2013</option> </select> </div> </div> </div> </div> </div> <div class="col-xs-12"> <a href="#" class="btn btn-default btn-minus pull-right btn-delete-school"><i class="fa fa-trash" aria-hidden="true"></i> Usuń</a> </div> </div>');
			}
		} else {
			alert('Osiągnięto maksymalną liczbę pozycji!');
		}
	});
	$(container).on("click", ".btn-delete-school", function(event) {
		event.preventDefault();
		$(this).closest('.school').fadeOut(500, function() { $(this).remove(); });
		exists--;
	});
}

// CV - ADD EXPERIENCE FIELDs
function addExperienceField() {
	var max = 3;
	var container = $('#experience-employers');
	var exists = $('.experience-employer').length;
	var id = 0;
	$('#btn-add-employer').click(function(event) {
		event.preventDefault();
		if (exists < max) {
			id++;
			if (exists % 2) { 
				exists++;
				$(container).append('<div class="row experience-employer even"> <div class="col-xs-12"> <div class="row"> <div class="col-xs-12 col-sm-6"> <div class="form-group"><label for="experience-employer-' + id + '" class="input-label">Pracodawca</label><input type="text" name="experience-employer[]" id="experience-employer-' + id + '" class="form-control input" placeholder="Nazwa firmy"></div> </div> <div class="col-xs-12 col-sm-6"> <div class="form-group"><label for="experience-position-' + id + '" class="input-label">Stanowisko</label><input type="text" name="experience-position[]" id="experience-position-' + id + '" class="form-control input" placeholder="Stanowisko"></div> </div> </div> </div> <div class="col-xs-12 col-sm-6"> <div class="form-group"> <label class="input-label">Początek</label> <div class="row"> <div class="col-xs-8 col-no-space"> <div class="form-group"> <label for="experience-beginning-month-' + id + '" class="input-label input-label-second">Miesiąc</label> <select id="experience-beginning-month-' + id + '" class="form-control input select" name="experience-beginning-month[]"> <option value="October">Październik</option> </select> </div> </div> <div class="col-xs-4 col-no-space"> <div class="form-group"> <label for="experience-beginning-year-' + id + '" class="input-label input-label-second">Rok</label> <select id="experience-beginning-year-' + id + '" class="form-control input select input-middle" name="experience-beginning-year[]"> <option value="2013">2013</option> </select> </div> </div> </div> </div> </div> <div class="col-xs-12 col-sm-6"> <div class="form-group"> <label class="input-label">Koniec</label> <div class="row"> <div class="col-xs-8 col-no-space"> <div class="form-group"> <label for="experience-end-month-' + id + '" class="input-label input-label-second">Miesiąc</label> <select id="experience-end-month-' + id + '" class="form-control input select" name="experience-end-month[]"> <option value="October">Październik</option> </select> </div> </div> <div class="col-xs-4 col-no-space"> <div class="form-group"> <label for="experience-end-year-' + id + '" class="input-label input-label-second">Rok</label> <select id="experience-end-year-' + id + '" class="form-control input select input-middle" name="experience-end-year[]"> <option value="">2013</option> </select> </div> </div> </div> </div> </div> <div class="col-xs-12"><a href="#" class="btn btn-default btn-minus pull-right btn-delete-employer"><i class="fa fa-trash" aria-hidden="true"></i> Usuń</a></div> </div>');
			}
			else { 
				exists++;
				$(container).append('<div class="row experience-employer"> <div class="col-xs-12"> <div class="row"> <div class="col-xs-12 col-sm-6"> <div class="form-group"><label for="experience-employer-' + id + '" class="input-label">Pracodawca</label><input type="text" name="experience-employer[]" id="experience-employer-' + id + '" class="form-control input" placeholder="Nazwa firmy"></div> </div> <div class="col-xs-12 col-sm-6"> <div class="form-group"><label for="experience-position-' + id + '" class="input-label">Stanowisko</label><input type="text" name="experience-position[]" id="experience-position-' + id + '" class="form-control input" placeholder="Stanowisko"></div> </div> </div> </div> <div class="col-xs-12 col-sm-6"> <div class="form-group"> <label class="input-label">Początek</label> <div class="row"> <div class="col-xs-8 col-no-space"> <div class="form-group"> <label for="experience-beginning-month-' + id + '" class="input-label input-label-second">Miesiąc</label> <select id="experience-beginning-month-' + id + '" class="form-control input select" name="experience-beginning-month[]"> <option value="October">Październik</option> </select> </div> </div> <div class="col-xs-4 col-no-space"> <div class="form-group"> <label for="experience-beginning-year-' + id + '" class="input-label input-label-second">Rok</label> <select id="experience-beginning-year-' + id + '" class="form-control input select input-middle" name="experience-beginning-year[]"> <option value="2013">2013</option> </select> </div> </div> </div> </div> </div> <div class="col-xs-12 col-sm-6"> <div class="form-group"> <label class="input-label">Koniec</label> <div class="row"> <div class="col-xs-8 col-no-space"> <div class="form-group"> <label for="experience-end-month-' + id + '" class="input-label input-label-second">Miesiąc</label> <select id="experience-end-month-' + id + '" class="form-control input select" name="experience-end-month[]"> <option value="October">Październik</option> </select> </div> </div> <div class="col-xs-4 col-no-space"> <div class="form-group"> <label for="experience-end-year-' + id + '" class="input-label input-label-second">Rok</label> <select id="experience-end-year-' + id + '" class="form-control input select input-middle" name="experience-end-year[]"> <option value="">2013</option> </select> </div> </div> </div> </div> </div> <div class="col-xs-12"><a href="#" class="btn btn-default btn-minus pull-right btn-delete-employer"><i class="fa fa-trash" aria-hidden="true"></i> Usuń</a></div> </div>');
			}
		} else {
			alert('Osiągnięto maksymalną liczbę pozycji!');
		}
	});
	$(container).on("click", ".btn-delete-employer", function(event) {
		event.preventDefault();
		$(this).closest('.experience-employer').fadeOut(500, function() { $(this).remove(); });
		exists--;
	});
}

// CV - ADD EXPERIENCE FIELDs
function addSkillField() {
	var max = 8;
	var container = $('#skills');
	var exists = $('.skill').length;
	var id = 0;
	$('#btn-add-skill').click(function(event) {
		event.preventDefault();
		if (exists < max) {
			id++;
			if (exists % 2) { 
				exists++;
				$(container).append('<div class="row skill even"> <div class="col-xs-12"> <div class="row"> <div class="col-xs-7 col-sm-8 col-no-space"> <div class="form-group"> <label for="skill-name-' + id + '" class="input-label">Umiejętność</label> <input type="text" name="skill-name[]" id="skill-name-' + id + '" class="form-control input" placeholder="Umiejętność"> </div> </div> <div class="col-xs-5 col-sm-4 col-no-space"> <div class="form-group"> <label for="skill-level-' + id + '" class="input-label">Poziom</label> <select id="skill-level-' + id + '" class="form-control input select" name="skill-level[]"> <option value="Intermediate">Zaawansowany</option> <option value="PreIntermediate">Średnio zaawansowany</option> <option value="Basic">Podstawowy</option> </select> </div> </div> </div> </div> <div class="col-xs-12"><a href="#" class="btn btn-default btn-minus pull-right btn-delete-skill"><i class="fa fa-trash" aria-hidden="true"></i> Usuń</a></div> </div>');
			}
			else { 
				exists++;
				$(container).append('<div class="row skill"> <div class="col-xs-12"> <div class="row"> <div class="col-xs-7 col-sm-8 col-no-space"> <div class="form-group"> <label for="skill-name-' + id + '" class="input-label">Umiejętność</label> <input type="text" name="skill-name[]" id="skill-name-' + id + '" class="form-control input" placeholder="Umiejętność"> </div> </div> <div class="col-xs-5 col-sm-4 col-no-space"> <div class="form-group"> <label for="skill-level-' + id + '" class="input-label">Poziom</label> <select id="skill-level-' + id + '" class="form-control input select" name="skill-level[]"> <option value="Intermediate">Zaawansowany</option> <option value="PreIntermediate">Średnio zaawansowany</option> <option value="Basic">Podstawowy</option> </select> </div> </div> </div> </div> <div class="col-xs-12"><a href="#" class="btn btn-default btn-minus pull-right btn-delete-skill"><i class="fa fa-trash" aria-hidden="true"></i> Usuń</a></div> </div>');
			}
		} else {
			alert('Osiągnięto maksymalną liczbę pozycji!');
		}
	});
	$(container).on("click", ".btn-delete-skill", function(event) {
		event.preventDefault();
		$(this).closest('.skill').fadeOut(500, function() { $(this).remove(); });
		exists--;
	});
}

// CV - ADD LANGUAGE FIELDs
function addLanguageField() {
	var max = 5;
	var container = $('#languages');
	var exists = $('.language').length;
	var id = 0;
	$('#btn-add-language').click(function(event) {
		event.preventDefault();
		if (exists < max) {
			id++;
			if (exists % 2) { 
				exists++;
				$(container).append('<div class="row language even"> <div class="col-xs-12"> <div class="row"> <div class="col-xs-9 col-sm-10 col-no-space"> <div class="form-group"> <label for="language-name-' + id + '" class="input-label">Język</label> <input type="text" name="language-name[]" id="language-name-' + id + '" class="form-control input" placeholder="Język obcy"> </div> </div> <div class="col-xs-3 col-sm-2 col-no-space"> <div class="form-group"> <label for="language-level-' + id + '" class="input-label input-label-second">Poziom</label> <select id="language-level-' + id + '" class="form-control input select input-middle" name="language-level[]"> <option value="A1">A1</option> <option value="A2">A2</option> <option value="B1">B1</option> <option value="B2">B2</option> <option value="C1">C1</option> <option value="C2">C2</option> </select> </div> </div> </div> </div> <div class="col-xs-12"> <a href="#" class="btn btn-default btn-minus pull-right btn-delete-language"><i class="fa fa-trash" aria-hidden="true"></i> Usuń</a> </div> </div>');
			}
			else { 
				exists++;
				$(container).append('<div class="row language"> <div class="col-xs-12"> <div class="row"> <div class="col-xs-9 col-sm-10 col-no-space"> <div class="form-group"> <label for="language-name-' + id + '" class="input-label">Język</label> <input type="text" name="language-name[]" id="language-name-' + id + '" class="form-control input" placeholder="Język obcy"> </div> </div> <div class="col-xs-3 col-sm-2 col-no-space"> <div class="form-group"> <label for="language-level-' + id + '" class="input-label input-label-second">Poziom</label> <select id="language-level-' + id + '" class="form-control input select input-middle" name="language-level[]"> <option value="A1">A1</option> <option value="A2">A2</option> <option value="B1">B1</option> <option value="B2">B2</option> <option value="C1">C1</option> <option value="C2">C2</option> </select> </div> </div> </div> </div> <div class="col-xs-12"> <a href="#" class="btn btn-default btn-minus pull-right btn-delete-language"><i class="fa fa-trash" aria-hidden="true"></i> Usuń</a> </div> </div>');
			}
		} else {
			alert('Osiągnięto maksymalną liczbę pozycji!');
		}
	});
	$(container).on("click", ".btn-delete-language", function(event) {
		event.preventDefault();
		$(this).closest('.language').fadeOut(500, function() { $(this).remove(); });
		exists--;
	});
}

// CV - ADD LANGUAGE FIELDs
function addInterestField() {
	var max = 12;
	var container = $('#interests');
	var exists = $('.interest').length;
	var id = 0;
	$('#btn-add-interest').click(function(event) {
		event.preventDefault();
		id++;
		if (exists < max) {
			exists++;
			$(container).append('<div class="col-xs-12 col-sm-6 col-md-4 interest"> <div class="row"> <div class="col-xs-10 col-no-space"> <div class="form-group"> <input type="text" name="interest[]" id="interest-' + id + '" class="form-control input" placeholder=""> </div> </div> <div class="col-xs-2 col-no-space"> <a href="#" class="btn btn-default btn-minus btn-delete-interest" title="Usuń"><i class="fa fa-minus-circle" aria-hidden="true"></i></a> </div> </div> </div>');
		}
		else {
			alert('Osiągnięto maksymalną liczbę pozycji!');
		}
	});
	$(container).on("click", ".btn-delete-interest", function(event) {
		event.preventDefault();
		$(this).closest('.interest').fadeOut(500, function() { $(this).remove(); });
		exists--;
	});
}