/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.utp.jobfinder.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.edu.utp.jobfinder.model.Cv;

/**
 *
 * @author bskibinski
 */
public class CvToPdf extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter pdfWriter,
            HttpServletRequest request,
            HttpServletResponse response)
            throws DocumentException {
        Cv cv = (Cv) model.get("cv");

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
        Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, BaseColor.LIGHT_GRAY);
        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.DARK_GRAY);

        Paragraph header = new Paragraph(cv.getFirstname() + " " + cv.getLastname().toUpperCase(), titleFont);
        DottedLineSeparator separator = new DottedLineSeparator();
        separator.setOffset(-2);
        separator.setGap(2f);
        header.add(separator);
        document.add(header);

        Paragraph personal = new Paragraph();
        personal.add(new Paragraph("PERSONAL INFORMATION", headerFont));
        personal.add(new Paragraph("Birthday: ", labelFont));
        personal.add(new Paragraph((String) model.get("birthDate"), contentFont));
        personal.add(new Paragraph("Phone: ", labelFont));
        personal.add(new Paragraph(cv.getPhone(), contentFont));
        personal.add(new Paragraph("Email: ", labelFont));
        personal.add(new Paragraph(cv.getEmail(), contentFont));
        personal.add(new Paragraph("Address: ", labelFont));
        personal.add(new Paragraph((String) model.get("address"), contentFont));
        document.add(personal);

        Paragraph education = new Paragraph();
        education.add(new Paragraph("EDUCATION", headerFont));
        education.add(new Paragraph("Level of education: ", labelFont));
        education.add(new Paragraph(cv.getLevelOfEducation().getLevelOfEducationEN(), contentFont));
        education.add(new Paragraph("Education title: ", labelFont));
        education.add(new Paragraph(cv.getEducationTitle().getTitleEN(), contentFont));
        if (!cv.getSchools().isEmpty() && cv.getSchools() != null) {
            List<String> educationDates = (List<String>) model.get("educationDates");
            education.add(new Paragraph("Schools: ", labelFont));
            for (int i = 0; i < cv.getSchools().size(); i++) {
                education.add(new Paragraph(educationDates.get(i) + ": " + cv.getSchools().get(i) + " - " + cv.getSubjects().get(i), contentFont));
            }
        }
        document.add(education);

        if (!cv.getEmployers().isEmpty() && cv.getEmployers() != null) {
            Paragraph experience = new Paragraph();
            experience.add(new Paragraph("EXPERIENCE", headerFont));
            experience.add(new Paragraph("Employers: ", labelFont));
            for (int i = 0; i < cv.getEmployers().size(); i++) {
                List<String> experienceDates = (List<String>) model.get("experienceDates");
                education.add(new Paragraph(experienceDates.get(i) + ": " + cv.getEmployers().get(i) + " - " + cv.getPositions().get(i), contentFont));
            }
            document.add(experience);
        }

        if (!cv.getSkills().isEmpty() && cv.getSkills() != null) {
            Paragraph skills = new Paragraph();
            skills.add(new Paragraph("SKILLS", headerFont));
            for (int i = 0; i < cv.getSkills().size(); i++) {
                skills.add(new Paragraph(cv.getSkills().get(i) + " - " + cv.getSkillsLevels().get(i).getSkillLevelEN(), contentFont));
            }
            document.add(skills);
        }

        if (!cv.getLanguages().isEmpty() && cv.getLanguages() != null) {
            Paragraph languages = new Paragraph();
            languages.add(new Paragraph("LANGUAGES", headerFont));
            for (int i = 0; i < cv.getLanguages().size(); i++) {
                languages.add(new Paragraph(cv.getLanguages().get(i) + " - " + cv.getLanguagesLevels().get(i).getLevelLabel(), contentFont));
            }
            document.add(languages);
        }

        Paragraph about = new Paragraph();
        about.add(new Paragraph("ABOUT", headerFont));
        if (!cv.getInterests().isEmpty() && cv.getInterests() != null) {
            Paragraph interests = new Paragraph();
            interests.add(new Paragraph("Interests: ", labelFont));
            for (int i = 0; i < cv.getInterests().size(); i++) {
                interests.add(new Paragraph(cv.getInterests().get(i), contentFont));
            }
            about.add(interests);
        }
        if (!cv.getAbout().isEmpty() && cv.getAbout() != null) {
            Paragraph description = new Paragraph();
            description.add(new Paragraph("About", labelFont));
            description.add(new Paragraph(cv.getAbout(), contentFont));
            about.add(description);
        }
        document.add(about);

    }

}
