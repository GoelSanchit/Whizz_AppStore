package corp.mahisan.medicinastore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 13-02-2015.
 */
public class Theraphy extends ActionBarActivity {
    public ExpandableListAdapter listAdapter;
    public ExpandableListView expListView;
    public List<String> listDataHeader;
    public HashMap<String, List<String>> listDataChild;
    Toolbar toolbar;
   // UserSession session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theraphy);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Theraphy");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader,
                listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id ==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        if(id == R.id.tour){
            Intent intent = new Intent(this,ListView1.class);
            startActivity(intent);
        }
        if(id == R.id.Medicina){
            Intent intent = new Intent(this,ListView2.class);
            startActivity(intent);
        }
        if(id == R.id.Social){
            Intent intent = new Intent(this,ListView3.class);
            startActivity(intent);
        }
        if(id == R.id.Shopping){
            Intent intent = new Intent(this,ListView4.class);
            startActivity(intent);
        }
        if(id == R.id.News){
            Intent intent = new Intent(this,ListView5.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Theraphy.this,ListView2.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        super.onBackPressed();
    }

    private void prepareListData() {
        // TODO Auto-generated method stub
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("A Theraphy");
        listDataHeader.add("B Theraphy");
        listDataHeader.add("C Theraphy");
        listDataHeader.add("D Theraphy");
        listDataHeader.add("E Theraphy");
        listDataHeader.add("F Theraphy");
        listDataHeader.add("G Theraphy");
        listDataHeader.add("H Theraphy");
        listDataHeader.add("I Theraphy");
        listDataHeader.add("K Theraphy");
        listDataHeader.add("L Theraphy");
        listDataHeader.add("M Theraphy");
        listDataHeader.add("N Theraphy");
        listDataHeader.add("O Theraphy");
        listDataHeader.add("P Theraphy");
        listDataHeader.add("R Theraphy");
        listDataHeader.add("S Theraphy");
        listDataHeader.add("T Theraphy");
        listDataHeader.add("V Theraphy");
        listDataHeader.add("Y Theraphy");

        // Adding child data
        List<String> A = new ArrayList<String>();
        A.add("Acid perfusion test:-\n"
                + "Acid perfusion test, also called the Bernstein test, is a test done to reproduce the pain when the lower esophagus is irrigated with an acid solution in patients with GERD (gastroesophageal reflux disease).");
        A.add("Allergy test:-\n"
                + "Allergy testing can help confirm or rule out allergies and consequently reduce adverse reactions and limit unnecessary avoidance and medications.Correct allergy diagnosis, counseling and avoidance advice based on valid allergy test results is of utmost importance and can help reduce the incidence of symptoms, need for medications and improve quality of life. A healthcare provider can use the test results to identify the specific allergic triggers that may be contributing to the symptoms. Using this information, along with a physical examination and case history, the doctor can diagnose the cause of the symptoms and tailor treatments that will help the patient feel better. A negative result can help the doctor rule out allergies in order to consider other possibilities. Ruling out allergies is as important as confirming them to limit unnecessary avoidance, worry and negative social impact.[");
        A.add("Anal Pap smear:-\n"
                + "An anal Pap smear is the anal counterpart of the cervical Pap smear.[1] It is used for the early detection of anal cancer. Some types of human papillomavirus (HPV) can cause anal cancer. Other HPV types cause anogenital warts. Cigarette smokers, homosexual men, individuals with a history of immunosuppression (such as in HIV infection) and women with a history of cervical, vaginal and vulval cancer are at increased risk of getting anal cancer[3]Vaccination against HPV before initial sexual exposure can reduce the risk of anal cancer.");
        A.add("Angioscopy:-\n"
                + "Angioscopy is a medical technique for visualizing the interior of blood vessels. In this technique, a flexible fiberoptic catheter inserted directly into an artery. It can be helpful in diagnosing e.g. arterial embolism.");
        A.add("Arterial resistivity index:-\n"
                + "The arterial resistivity index (also called as Resistance index, abbreviated as RI), developed by Leandre Pourcelot, is a measure of pulsatile blood flow that reflects the resistance to blood flow caused by microvascular bed distal to the site of measurement.");
        A.add("Autoinoculation:-\n"
                + "Autoinoculation can refer to both beneficial medical procedures (e.g. vaccination) as well as non-beneficial or harmful natural processes (e.g. infection or disease). One beneficial autoinoculation medical procedure is when cells are removed from a person's body, medically altered then reinserted (\"implanted\" or \"infected\") into the same organism or person again to achieve some diagnostic or treatment aim");

        List<String> B = new ArrayList<String>();
        B.add("Ballistocardiography:-"
                + "\nThe ballistocardiograph (BCG) is a measure of ballistic forces on the heart.[1] Ballistocardiography is a technique for producing a graphical representation of repetitive motions of the human body arising from the sudden ejection of blood into the great vessels with each heart beat.[2] It is a vital sign in the 1-20 Hz frequency range which is caused by the mechanical movement of the heart and can be recorded by noninvasive methods from the surface of the body. It was shown for the first time, after an extensive research work by Dr. Isaac Starr, that the effect of main heart malfunctions can be identified by observing and analyzing the BCG signal.");
        B.add("BASDAI:-"
                + "\nThe BASDAI or Bath Ankylosing Spondylitis Disease Activity Index is a validated diagnostic test which allows a physician, usually a rheumatologist, to determine the effectiveness of a current drug therapy, or the need to institute a new drug therapy for the treatment of Ankylosing spondylitis (AS). The BASDAI is one of a group of classification criteria for spondyloarthropathies.");
        B.add("BASFI:-"
                + "\nThe Bath Ankylosing Spondylitis Functional Index was named for the location of the institution (Bath England) where authors A. Calin and co-workers developed this validated index to determine the degree of functional limitation in patients with the inflammatory autoimmune disease Ankylosing Spondylitis (AS). These researchers recognized that although treatment for AS is focused on pain control and the improvement of function, the available methods of assessing function were not specific to AS and were inadequately validated. In their seminal 1994 publication, Calin and his associates stated that \"after pain and stiffness (measured by the BASDAI test), one of the most important complaints of patients with AS is disability.");
        B.add("BLOODLETTING:-"
                + "\nBloodletting (or blood-letting) is the withdrawal of blood from a patient to cure or prevent illness and disease. Bloodletting was based on an ancient system of medicine in which blood and other bodily fluid were regarded as \"humors\" that had to remain in proper balance to maintain health. It is claimed to have been the most common medical practice performed by surgeons from antiquity until the late 19th century, a span of almost 2,000 years.");
        B.add("Bone Marrow Examination:-"
                + "\nBone marrow examination refers to the pathologic analysis of samples of bone marrow obtained by bone marrow biopsy (often called a trephine biopsy) and bone marrow aspiration. Bone marrow examination is used in the diagnosis of a number of conditions, including leukemia, multiple myeloma, lymphoma, anemia, and pancytopenia. The bone marrow produces the cellular elements of the blood, including platelets, red blood cells and white blood cells. While much information can be gleaned by testing the blood itself (drawn from a vein by phlebotomy), it is sometimes necessary to examine the source of the blood cells in the bone marrow to obtain more information on hematopoiesis; this is the role of bone marrow aspiration and biopsy.");
        B.add("Boston Diagnostic Aphasia Examination:-"
                + "\nThe Boston Diagnostic Aphasia Examination or BDAE is a neuropsychological battery used to evaluate adults suspected of having aphasia, and is currently in its third edition.[1] It was created by Harold Goodglass and Edith Kaplan. The BDAE evaluates language skills based on perceptual modalities (auditory, visual, and gestural), processing functions (comprehension, analysis, problem-solving), and response modalities (writing, articulation, and manipulation). Administration time ranges from 35 to 45 minutes. Many other tests are sometimes used by neurologists and speech language pathologists on a case-by-case basis, and other comprehensive tests exist like the Western Aphasia Battery.");
        B.add("Brainwave Entrainment:-"
                + "\nBrainwave entrainment is any practice that aims to cause brainwave frequencies to fall into step with a periodic stimulus having a frequency corresponding to the intended brain-state (for example, to induce sleep), usually attempted with the use of specialized software. It purportedly depends upon a \"frequency following\" response on the assumption that the human brain has a tendency to change its dominant EEG frequency towards the frequency of a dominant external stimulus.");
        B.add("Bronchial Challenge Test:-"
                + "\nA bronchial challenge test is a medical test used to assist in the diagnosis of asthma.[1] The patient breathes in nebulized methacholine or histamine. Thus the test may also be called a methacholine challenge test or histamine challenge test respectively. ");
        B.add("Bronchoalveolar Lavage:-"
                + "\nBronchoalveolar lavage (BAL) is a medical procedure in which a bronchoscope is passed through the mouth or nose into the lungs and fluid is squirted into a small part of the lung and then collected for examination. BAL is typically performed to diagnose lung disease.");
        B.add("Bone Conduction Auditory Brainstem Response:-"
                + "\nBone-conduction auditory brainstem response or BCABR is a type of auditory evoked response that records neural response from EEG with stimulus transmitted through bone conduction.");

        List<String> C = new ArrayList<String>();
        C.add("California Mastitis Test:-"
                + "\nThe California Mastitis Test (CMT) is a simple cow-side indicator of the somatic cell count of milk. It operates by disrupting the cell membrane of any cells present in the milk sample, allowing the DNA in those cells to react with the test reagent, forming a gel.[1] It provides a useful technique for detecting subclinical mastitis.");
        C.add("CAMP Test:-"
                + "\nThe CAMP test is a test to identify Group B β-streptococci[1][2] based on their formation of a substance (CAMP factor[3]) that enlarges the area of hemolysis formed by β-hemolysin from Staphylococcus aureus. It is frequently used to identify Listeria spp.");
        C.add("Cannabis Drug Testing:-"
                + "\nCannabis drug testing describes various drug test methodologies for the use of cannabis in medicine, sport, and law. Cannabis use is highly detectable and can be detected by urinalysis, hair analysis, as well as saliva tests for days or weeks.");
        C.add("Cardiac Catheterization:-"
                + "\nCardiac catheterization (heart cath) is the insertion of a catheter into a chamber or vessel of the heart. This is done both for diagnostic and interventional purposes. Subsets of this technique are mainly coronary catheterization, involving the catheterization of the coronary arteries, and catheterization of cardiac chambers and valves of the Cardiac System.");
        C.add("Cardiac Stress Test:-"
                + "\nCardiac stress test (or Cardiac diagnostic test) is a test used in medicine and cardiology to measure the heart's ability to respond to external stress in a controlled clinical environment.");
        C.add("Carrier Testing:-"
                + "\nCarrier testing is a type of genetic testing that is used to determine if a person is a carrier for a specific autosomal recessive diseases.[1] This kind of testing is used most often by couples who are considering becoming pregnant to determine the risks of their child inheriting one of these genetic disorders.");
        C.add("Chemosensitivity Assay:-"
                + "\nA chemosensitivity assay is a laboratory test that measures the number of tumor cells that are killed by chemotherapy. The test is done after the tumor cells are removed from the body. A chemosensitivity assay may help in choosing the best drug or drugs for the cancer being treated.");
        C.add("CNS Vital Signs Computerized Neurocognitive Test:-"
                + "\nhe CNS Vital Signs computerized neuropsychological test platform is used to measure brain function or cognitive domains and examining testing effort for both children and adults (ages 8 – 90 years). The test is used to rapidly evaluate and subsequently track and manage neuropsychiatric symptoms, behaviors, and comorbidities. Results of testing are provided immediately after a test is completed and typically taken in context with other relevant clinical information such as history, physical examination, other psychological or neuropsychological tests, lab results, imaging studies, etc., in accordance with good clinical practice standards.");
        C.add("Colonic Polypectomy:-"
                + "\nThe method used to perform colonic polypectomies during colonoscopy depends on the size, shape and histological type of the polyp to be removed. Prior to performing polypectomy, polyps can be biopsied and examined histologically to determine the need to perform polypectomy.");
        C.add("Comprehensive Aphasia Test:-"
                + "\nThe Comprehensive Aphasia Test (CAT) was created by Kate Swinburn, Gillian Porter and David Howard. The CAT is a new test for people who have acquired aphasia, the impairment of language ability. The comprehensive assessment can be completed over one or two sessions. The test contains a cognitive screening, a language battery and a disability questionnaire.");
        C.add("X-ray Computed Tomography:-"
                + "\nX-ray computed tomography (x-ray CT) is a technology that uses computer-processed x-rays to produce tomographic images (virtual 'slices') of specific areas of the scanned object, allowing the user to see inside without cutting. Digital geometry processing is used to generate a three-dimensional image of the inside of an object from a large series of two-dimensional radiographic images taken around a single axis of rotation.[1] Medical imaging is the most common application of x-ray CT. Its cross-sectional images are used for diagnostic and therapeutic purposes in various medical disciplines.[2] The rest of this article discusses medical-imaging x-ray CT; industrial applications of x-ray CT are discussed at industrial computed tomography scanning.");
        C.add("Cranio-Corpography:-"
                + "\nCranio-Corpo-Graphy (CCG) is a medical investigation and measurement procedure developed in 1968 by German neurootologist Claus-Frenz Claussen. It documents and evaluates disorders of the equilibrium function measured by investigation procedures such as the Unterberger test, the LOLAVHESLIT test, the NEFERT test, the Romberg's test and the WOFEC test.");
        C.add("Cystometry:-"
                + "\nCystometry, also known as flow cystometry, is a clinical diagnostic procedure used to evaluate bladder function. Specifically, it measures contractile force of the bladder when voiding. The resulting chart generated from cystometric analysis is known as a cystometrogram (CMG), which plots volume of liquid emptied from bladder against intravesical pressure.");
        C.add("Cytometry:-"
                + "\nCytometry is a general name for a group of biological methods used to measure various parameters of cells. Parameters which can be measured by cytometric methods are for example cell size and morphology, cell cycle phase, DNA content, the existence or absence of specific proteins on the cell surface or in the cytoplasm.[1] Cytometry is used to characterize and count blood cells in the common blood test. In a similar fashion, cytometry is also used in cell biology research and in medical diagnostics to characterize cells in a wide range of applications associated with diseases such as cancer and AIDS.");
        C.add("Czermak–Hering Test:-"
                + "\nCzermak–Hering test is a vagal maneuver and consist in external digital pressure applied to the carotid sinus.[1] Is in the patient's bedside to impose moderate pressure with your fingers turn left and right carotid artery for continuous massage.");

        List<String> D = new ArrayList<String>();
        D.add("DecisionDx-UM:-"
                + "\nDecisionDx-UM is a prognostic test that accurately determines the metastatic risk associated with ocular melanoma tumors of the eye. Ocular melanoma is a term commonly used to describe tumors of the uveal tract such as uveal melanoma, choroidal melanoma, ciliary body melanoma, and iris melanoma. The DecisionDx-UM test was clinically validated on these tumors of the uveal tract. DecisionDx-UM assesses the gene expression profile (GEP) of a subset of genes which are differentially expressed in primary tumor cells compared to cells that have undergone transformation to a metastatic phenotype. ");
        D.add("Differential Staining:-"
                + "\nDifferential Staining is a general term that can refer to a number of specific processes. Generally, it is used to describe staining processes which use more than one chemical stain. Using multiple stains can better differentiate between different microorganisms or structures/cellular components of a single organism.");
        D.add("Differential Vascular Labeling:-"
                + "\nDifferential Vascular Labeling is a labeling method that allows differentiation between blood and lymphatic systems for intravital imaging. This approach takes advantage of the differences in particle distribution across blood and lymphatic endothelia. The DVL is based on a single intravenous injection of a fluorescent particles of different size. Due to differential distribution of fluorescent particles by size the larger particles remain in blood whereas the smaller once diffuses out of blood and into the lymphatic system thus functionally labeling the vasculature. ");
        D.add("Divided Visual Field Paradigm:-"
                + "\nThe Divided Visual Field Paradigm is an experimental technique that involves measuring task performance when visual stimuli are presented on the left or right visual hemifields. If a visual stimulus appears in the left visual field (LVF), the visual information is initially projected to the right cerebral hemisphere (RH), and conversely, if a visual stimulus appears in the right visual field (RVF), the visual information is initially received by the left cerebral hemisphere (LH)");
        D.add("Drug Test:-"
                + "\nA drug test is a technical analysis of a biological specimen, for example urine, hair, blood, breath air, sweat, or oral fluid / saliva – to determine the presence or absence of specified parent drugs or their metabolites. Major applications of drug testing include detection of the presence of performance enhancing steroids in sport, employers screening for drugs prohibited by law (such as cannabis, cocaine and heroin) and police officers testing for the presence and concentration of alcohol (ethanol) in the blood commonly referred to as BAC (blood alcohol content)");
        D.add("Duochrome test:-"
                + "\nA Duochrome Test is a test commonly used to refine the final sphere in refraction, which makes use of the chromatic aberration of the eye. Because of the chromatic aberration of the eye, the shorter wavelengths (green) are focused in front of the longer red wavelengths.");

        List<String> E = new ArrayList<String>();
        E.add("EEG-fMRI:-"
                + "\nEEG-fMRI (short for EEG-correlated fMRI or electroencephalography-correlated functional magnetic resonance imaging) is a multimodal neuroimaging technique whereby EEG and fMRI data are recorded synchronously for the study of electrical brain activity in correlation with haemodynamic changes in brain during the electrical activity, be it normal function or associated with disorders.");
        E.add("Electrocochleography:-"
                + "\nElectrocochleography (abbreviated ECochG or ECOG) is a technique of recording electrical potentials generated in the inner ear and auditory nerve in response to sound stimulation, using an electrode placed in the ear canal or tympanic membrane. The test is performed by an otologist or audiologist with specialized training, and is used for detection of elevated inner ear pressure (endolymphatic hydrops) or for the testing and monitoring of inner ear and auditory nerve function during surgery.");
        E.add("Elek's Test:-"
                + "\nElek's test, also known as the immuno diffusion technique, is an in vitro virulence test performed upon Corynebacterium diphtheriae.[1] It is used to test for toxigenicity of C. diphtheriae.");
        E.add("Elimination Diet:-"
                + "\nAn elimination diet is a method of identifying foods that an individual cannot consume without adverse effects.[1] Adverse effects may be due to food allergy, food intolerance, other physiological mechanisms (such as metabolic or toxins),[2] or a combination of these. Elimination diets typically involve entirely removing a suspected food from the diet for a period of time from two weeks to two months, and waiting to determine whether symptoms resolve during that time period. In rare cases, a health professional may wish to use an oligoantigenic diet to relieve a patient of symptoms they are experiencing.");
        E.add("Endoluminal Capsule Monitoring:-"
                + "\nEndoluminal capsule monitoring is a non-invasive medical diagnostic procedure which uses a miniaturized wireless radio transmitter embedded into an ingestible water-tight capsule. The patient ingests the capsule and while it transits through the gastrointestinal system, it sends signals to the outside, which are captured by a radio receiver, processed, displayed and stored in a computer.");
        E.add("Esophageal Electrophysiologic Procedure:-"
                + "\nThe esophageal electrophysiologic procedure is a procedure used to detect cardiac arrhythmias.\nA nasal tube is placed into the nostril and fed into the esophagus. EKG readings from this area are much more accurate due to the close proximity to the heart.");
        E.add("Esophageal Motility Study:-"
                + "\nAn esophageal motility study (EMS) or esophageal manometry is a test to assess motor function of the upper esophageal sphincter (UES), esophageal body and lower esophageal sphincter (LES).");
        E.add("Evocative/suppression testing:-"
                + "\nEvocative/suppression testing refers to a class of tests performed where one substance is measured both before and after the administration of another substance to determine if the levels are stimulated (\"evocative\") or suppressed.");
        E.add("Evoked Potential:-"
                + "\nAn evoked potential or evoked response is an electrical potential recorded from the nervous system of a human or other animal following presentation of a stimulus, as distinct from spontaneous potentials as detected by electroencephalography (EEG), electromyography (EMG), or other electrophysiological recording method.");
        E.add("Exosome (vesicle):-"
                + "\nThe Esosomo are cell-derived vesicles that are present in many and perhaps all biological fluids, including blood, urine, and cultured medium of cell cultures.[1][2] The reported diameter of exosomes is between 30 and 100 nm, which is larger than LDL, but much smaller than for example red blood cells.");

        List<String> F = new ArrayList<String>();
        F.add("False positives and false negatives:-"
                + "\nIn medical testing, and more generally in binary classification, a false positive is when a test result indicates that a condition – such as a disease – is present (the result is positive), but it is not in fact present (the result is false), while a false negative is when a test result indicates that a condition is not present (the result is negative), but it is in fact present (the result is false). These are the two kinds of errors in a binary test, and are contrasted with a correct result, either a true positive or a true negative. These are also known in medicine as a false positive diagnosis (resp. false negative diagnosis), and in statistical classification as a false positive error (resp. false negative error).");
        F.add("Fern Test:-"
                + "\nFern test refers to detection of a characteristic 'fern like' pattern of cervical mucus when a specimen of cervical mucus is allowed to dry on a glass slide and is viewed under a low power microscope. Fern test is used to provide indirect evidence of ovulation and fertility, however this test does not predict the time of ovulation.\nFerning is due to the presence of sodium chloride in the mucus under estrogen effect. When high levels of estrogen are present, just before ovulation, the cervical mucus forms fern-like patterns due to crystallization of sodium chloride on mucus fibers. This pattern is known as arborization or 'ferning'.");
        F.add("Fibrinogen Uptake Test:-"
                + "\nA fibrinogen uptake test is a test that was formerly used to detect deep vein thrombosis. Radioactive labeled fibrinogen is given which is incorporated in the thrombus. The thrombus can then be detected by scintigraphy.");
        F.add("Flatline:-"
                + "\nA flatline is an electrical time sequence measurement that shows no activity and therefore, when represented, shows a flat line instead of a moving one. It almost always refers to either a flatlined electrocardiogram, where the heart shows no electrical activity (asystole), or to a flat electroencephalogram, in which the brain shows no electrical activity (brain death). Both of these specific cases are involved in various definitions of death. ");
        F.add("Flexible Endoscopic Evaluation of Swallowing with Sensory Testing:-"
                + "\nFlexible Endoscopic Evaluation of Swallowing with Sensory Testing (FEESST), or laryngopharyngeal sensory testing, is a technique used to directly examine motor and sensory functions of swallowing so that proper treatment can be given to patients with swallowing difficulties to decrease their risk of aspiration (food and liquids going into the lungs instead of the stomach) and choking. FEESST was invented by Dr. Jonathan E. Aviv MD, FACS in 1993,[1] and has been used by otolaryngologists (ear, nose and throat doctors),[2] pulmonologists (lung doctors),[3] gastroenterologists (stomach and digestion doctors),[4] intensivists (intensive care specialists)[5] and speech-language pathologists [6] for the past 20 years.");
        F.add("Flow Cytometry:-"
                + "\nIn biotechnology, flow cytometry is a laser-based, biophysical technology employed in cell counting, cell sorting, biomarker detection and protein engineering, by suspending cells in a stream of fluid and passing them by an electronic detection apparatus. It allows simultaneous multiparametric analysis of the physical and chemical characteristics of up to thousands of particles per second.");
        F.add("Flow-through Test:-"
                + "\nFlow-through tests are a type of diagnostic assay that allows users to test for the presence of a biomarker, usually a specific antibody, in a sample such as blood. Detection of a specific biomarker aids in the diagnosis of and allows therapeutic action to be initiated quickly. The field of applications for this technology is wide, whereas generally all applications applying lateral flow tests can be replaced by flow-through assays. Commercial applications mainly target testing for infectious disease, both by viruses (e.g. HIV, Hepatitis C, Hepatitis B [1] ) or bacteria ");
        F.add("Fluid Deprivation Test:-"
                + "\nA fluid or water deprivation test is a medical test[1] which can be used to determine whether the patient has diabetes insipidus as opposed to other causes of polydipsia (a condition of excessive thirst that causes an excessive intake of water). The patient is required, for a prolonged period, to forgo intake of water completely, to determine the cause of the thirst.\nThis test measures changes in body weight, urine output, and urine composition when fluids are withheld. Sometimes measuring blood levels of ADH (a synonym for vasopressin) during this test is also necessary.");
        F.add("Fluorescent glucose biosensor:-"
                + "\nFluorescent glucose biosensors are devices that measure the concentration of glucose in diabetic patients by means of sensitive protein that relays the concentration by means of fluorescence, an alternative to amperometric sension of glucose. No device has yet entered the medical market,[nb 1] but, due to the prevalence of diabetes, it is the prime drive in the construction of fluorescent biosensors.");
        F.add("Focused Impedance Measurement:-"
                + "\nFocused Impedance Measurement (FIM) is a recent technique for measuring tissue impedance in the human body with improved zone localization compared to conventional methods. This method was proposed and developed by Department of Biomedical Physics and Technology of University of Dhaka under the supervision of Prof. Khondkar Siddique-e-Rabbani;[1][2] who first introduced the idea. FIM can be considered a bridge between Four Electrode Impedance Measurement (FEIM) and Electrical impedance Tomography (EIT), and provides a middle ground in terms of simplicity and accuracy.");

        List<String> G = new ArrayList<String>();
        G.add("Gastric Tonometry:-"
                + "\nGastric tonometry describes the measurement of the carbon dioxide level inside the stomach in order to assess the degree of blood flow to the stomach and bowel.\nThe measurement of gut mucosal carbon dioxide has been used to detect decreased blood flow. Accumulation of carbon dioxide is predominantly a result of hypoperfusion and not hypoxia. Because the introduction of a nasogastric tube is almost routine in critically ill patients, the measurement of gastric carbon dioxide can be an easy method to monitor tissue perfusion.");
        G.add("Genetic testing:-"
                + "\nGenetic testing, also known as DNA testing, allows the genetic diagnosis of vulnerabilities to inherited diseases, and can also be used to determine a child's parentage (genetic mother and father) or in general a person's ancestry or biological relationship between people. In addition to studying chromosomes to the level of individual genes, genetic testing in a broader sense includes biochemical tests for the possible presence of genetic diseases, or mutant forms of genes associated with increased risk of developing genetic disorders. Genetic testing identifies changes in chromosomes, genes, or proteins.");
        G.add("GeneXpert MTB/RIF:-"
                + "\nThe Xpert MTB/RIF is a cartridge-based, automated diagnostic test that can identify Mycobacterium tuberculosis (MTB)DNA and resistance to rifampicin (RIF)by nucleic acid amplification technique(NAAT). It was co-developed by the laboratory of Professor David Alland at the University of Medicine and Dentistry of New Jersey (UMDNJ)., Cepheid Inc. and Foundation for Innovative New Diagnostics, with additional financial support from the US National Institutes of Health (NIH).");
        G.add("GERRI:-"
                + "\nGERRI, an acronym for Geriatric Evaluation by Relative's Rating Instrument, is a diagnostic tool for rating cognitive function, social function and mood in geriatric patients.");
        G.add("Gold Standard (test):-"
                + "\nIn medicine and statistics, gold standard test refers to a diagnostic test or benchmark that is the best available under reasonable conditions. It does not have to be necessarily the best possible test for the condition in absolute terms. For example, in medicine, dealing with conditions that require an autopsy to have a perfect diagnosis, the gold standard test is less accurate than the autopsy.");

        List<String> H = new ArrayList<String>();
        H.add("H Antigen:-"
                + "\nH antigen can refer to one of various types of antigens having diverse biological functions:\nAlso known as substance H, a precursor to each of the ABO blood group antigens, apparently present in all people except those with the Bombay Blood phenotype (see Hh antigen system)");
        H.add("Ham Test:-"
                + "\nThe Ham test is a test used in the diagnosis of paroxysmal nocturnal hemoglobinuria (PNH). The test involves placing red blood cells in mild acid; a positive result (increased RBC fragility) indicates PNH or Congenital dyserythropoietic anemia. This is now an obsolete test for diagnosing PNH due to its low sensitivity and specificity.");
        H.add("Hamster egg penetration test:-"
                + "\nHamster egg-penetration test (HEPT) (or simply Sperm penetration test) is in-vitro test used to study physiological profile of spermatozoa. It makes use of zona-free hamster egg, which resembles human ovum. A normal sperm is capable of penetrating the egg, showing its fertilizing capacity. The test is expensive and not reliable.");
        H.add("Hamster zona-free ovum test:-"
                + "\nThe hamster zona-free ovum test (HZFO test), or hamster test is a method for diagnosing male infertility due to the inability of the sperm to penetrate the ova. This test has limited value for most people experiencing infertility.");
        H.add("Harvard Step Test:-"
                + "\nThe Harvard Step Test is a type of cardiac stress test for detecting and/or diagnosing cardiovascular disease. It also is a good measurement of fitness, and your ability to recover after a strenuous exercise. The more quickly your heart rate returns to resting, the better shape you are in.\nIt is a kind of cardiovascular endurance test. The test computes the capability to exercise continuously for extended intervals of time without tiring.");
        H.add("Heidelberg Test:-"
                + "\nThe Heidelberg test is a medical diagnostic test used in the diagnosis of hypochlorhydria, i.e. insufficient hydrochloric acid in the stomach.\nWhen performing the Heidelberg test, the patient swallows a small electronic device about the size of a vitamin capsule. This device tracks acid levels in the stomach as the patient swallows small amounts of baking soda, which neutralises the hydrochloric acid in the stomach. If the acid level does not return to normal after the baking soda is swallowed, the patient has hypochlorhydria");
        H.add("High Resolution Manometry:-"
                + "\nHigh-resolution manometry (HRM) is a gastrointestinal motility diagnostic system that measures intraluminal pressure activity in the gastrointestinal tract using a series of closely spaced pressure sensors. For a manometry system to be classified as \"high-resolution\" as opposed to \"conventional\", the pressure sensors need to be spaced at most 1 cm apart.[citation needed] Two dominant pressure transduction technologies are used: solid state pressure sensors and water perfused pressure sensors.[citation needed] Each pressure transduction technology has its own inherent advantages and disadvantages. HRM systems also require advanced computer hardware and software to store and analyze the manometry data.");
        H.add("Checkpoint (rapid HIV testing facility):-"
                + "\nCheckpoint was the name of the first rapid HIV testing facility in the Netherlands.[1] This project, run on a voluntary basis, was based in Amsterdam. From 21 June 2002 until its closure on 27 June 2008 almost 5000 people opted for a Checkpoint HIV test.");
        H.add("Holmes rebound phenomenon:-"
                + "\nThe Holmes Rebound phenomenon is a sign of cerebellar disease. There are two ways of eliciting the sign:\n\n1. With patient having their arms outstretched, you ask the patient to keep their arms in that position as you press down on their arm. As you release your hand, their arm shoots up above the position it originally was and bounces up.\n\n2. Flex the patients elbow. Ask the patient to keep their arm in that position as you pull away, when you release the arm, the arm will hit the patient's body.");

        List<String> I = new ArrayList<String>();
        I.add("Impedance Phlebography:-"
                + "\nImpedance phlebography, or impedance plethysmography (IPG), is a non-invasive medical test that measures small changes in electrical resistance of the chest, calf or other regions of the body. These measurements reflect blood volume changes, and can indirectly indicate the presence or absence of venous thrombosis. This procedure provides an alternative to venography, which is invasive and requires a great deal of skill to execute adequately and interpret accurately.");
        I.add("Inferior Petrosal Sinus Sampling:-"
                + "\nInferior petrosal sinus sampling is a relatively new approach to the diagnosis of Cushing's disease.[1]\nIn essence, it tests to see the source of the raised ACTH levels in a patient with diagnosed Cushing's syndrome and high or normal serum ACTH levels. The inferior petrosal sinus is where the pituitary gland drains. Therefore, a sample from here showing raised ACTH compared to the periphery suggests that it is a pituitary cause of Cushing's, i.e. Cushing's disease.");
        I.add("International Biosciences:-"
                + "\nInternational Biosciences (IBDNA), is a UK-based DNA testing company with offices in Brighton, East Sussex. The company offers a range of DNA tests including the Natera Panorama prenatal test as well as peace of mind relationship tests, ancestry and genetic predisposition testing., International Biosciences operates worldwide and has operations in Ireland, France, Germany, Spain, Italy, Canada and India.");
        I.add("ISET Test:-"
                + "\nThe ISET Test (Isolation by Size of Tumor cells / Trophoblastic cells) is a diagnostic blood test that detects circulating tumor cells in a blood sample.[1][2][3] The test uses an in-vitro diagnostic system developed at INSERM, the Université Paris Descartes and Assistance Publique Hôpitaux de Paris (AP-HP) in order to isolate cancer cells from blood without loss and identify them through a diagnostic cytopathology-based approach.");

        List<String> K = new ArrayList<String>();
        K.add("Kurzrock–Miller test:-"
                + "\nThe Kurzrock–Miller test is an in-vitro test of sperm–mucus interaction. It consists of establishing an interface between cervical mucus and liquefied semen.[1] It is one of the tests used for investigating infertility.");

        List<String> L = new ArrayList<String>();
        L.add("Langleys Nicotine Test:-"
                + "\nThe Langley Nicotine test is used to determine the relay-site of autonomic fibers.\nThe test is the following: First stimulate the preganglionic fiber and notice the response that appears. By adding a large dose of nicotine, the ganglion (site of relay between pre- and postganglionic fibers) is blocked. Now the preganglionic fiber is restimulated again.");
        L.add("Lateral Flow Test:-"
                + "\nLateral flow tests also known as lateral flow immunochromatographic assays, are simple devices intended to detect the presence (or absence) of a target analyte in sample (matrix) without the need for specialized and costly equipment, though many lab based applications exist that are supported by reading equipment. Typically, these tests are used for medical diagnostics either for home testing, point of care testing, or laboratory use. A widely spread and well known application is the home pregnancy test.");
        L.add("Latex Fixation Test:-"
                + "\nThe latex agglutination method is used clinically in the identification and typing of many important microorganisms. These tests are based on and utilize the patient's antigen-antibody immune response. [This response occurs when the body detects a pathogen and forms an antibody specific to an identified antigen (a protein configuration) present on the surface of the pathogen.");
        L.add("Lesion-Specific Calcium Score:-"
                + "\nThe lesion-specific calcium score is a method of calcium measurement that results from a CT test for coronary artery calcification.\nCoronary disease, which most often is equated with atherosclerotic coronary artery disease, has been identified as the leading cause of death worldwide. The initial presentation of coronary artery disease in half of all patients presents in sudden cardiac death outside of the hospital most often resulting in the patient’s death.");
        L.add("Liebermann–Burchard Test:-"
                + "\nThe Liebermann–Burchard or acetic anhydride test is used for the detection of cholesterol. The formation of a green or green-blue colour after a few minutes is positive.\nLieberman–Burchard is a reagent used in a colourimetric test to detect cholesterol, which gives a deep green colour. This colour begins as a purplish, pink colour and progresses through to a light green then very dark green colour. The colour is due to the hydroxyl group (-OH) of cholesterol reacting with the reagents and increasing the conjugation of the un-saturation in the adjacent fused ring. Since this test uses acetic anhydride and sulfuric acid as reagents, caution must be exercised so as not to receive severe burns.");
        L.add("LOLAVHESLIT:-"
                + "\nLOLAVHESLIT (longitudinal, lateral, vertical head-sliding test) is a medical examination procedure developed in 1999 by German neurootologist Claus-Frenz Claussen.\nThe procedure serves in diagnosing diseases in relation to cervical vertebrae and the vertebral column as well as diagnosing movement disorders of the neck.\nThe patient performs the necessary moves in a sitting position in order to avoid unconscious body movements affecting the investigation results. Additionally, the patient stretches his arms and positions his hands between his knees for the same reasons. The head movements, which are performed during the investigation and between which the head is relocated each time into the normal position");

        List<String> M = new ArrayList<String>();
        M.add("Magnetocardiography:-"
                + "\nMagnetocardiography (MCG) is a technique to measure the magnetic fields produced by electrical activity in the heart using extremely sensitive devices such as the superconducting quantum interference device (SQUID). If the magnetic field is measured using a multichannel device, a map of the magnetic field is obtained over the chest; from such a map, using mathematical algorithms that take into account the conductivity structure of the torso, it is possible to locate the source of the activity. For example, sources of abnormal rhythms or arrhythmia, may be located using MCG.");
        M.add("Magnetoencephalography:-"
                + "\nMagnetoencephalography (MEG) is a functional neuroimaging technique for mapping brain activity by recording magnetic fields produced by electrical currents occurring naturally in the brain, using very sensitive magnetometers. Arrays of SQUIDs (superconducting quantum interference devices) are currently the most common magnetometer, while the SERF (spin exchange relaxation-free magnetometer) is being investigated for future machines. Applications of MEG include basic research into perceptual and cognitive brain processes, localizing regions affected by pathology before surgical removal, determining the function of various parts of the brain, and neurofeedback. This can be applied in a clinical setting to find locations of abnormalities as well as in an experimental setting to simply measure brain activity");
        M.add("Mechanography:-"
                + "\nMechanography (also referred to as jumping mechanography) is a medical diagnostic measurement method for motion analysis by means of physical parameters. The variation of the ground reaction forces over the time of a motion like typical every day movements (e.g. chair rise or jumps) are measured and centre of gravity related physical parameters like relative maximum forces, velocity, power output, kinetic energy, potential energy, height of jump or whole body stiffness are calculated. If the ground reaction forces are measured separately for left and right leg in addition body imbalances during the motions can be analysed. This enables for example to document the results of therapy. The same methodology can also be used for gait analysis or for analysis of stair climbing.");
        M.add("Mechanomyogram:-"
                + "\nThe mechanomyogram (MMG) is the mechanical signal observable from the surface of a muscle when the muscle is contracted. At the onset of muscle contraction, gross changes in the muscle shape cause a large peak in the MMG. Subsequent vibrations are due to oscillations of the muscle fibres at the resonance frequency of the muscle. The mechanomyogram is also known as the phonomyogram, acoustic myogram, sound myogram or vibromyogram.");
        M.add("Miller Fisher Test:-"
                + "\nThe Miller Fisher Test (also known as the lumbar tap test) is used to decide whether shunting of cerebrospinal fluid (CSF) would be helpful in a patient with normal pressure hydrocephalus (NPH). The test involves removing 50 mL of CSF, after which cognitive function is clinically reassessed.\nClinical improvement showed a high predictive value for subsequent success with shunting. A \"negative\" test has a very low predictive accuracy, as many patients may improve after a shunt in spite of lack of improvement after CSF removal.");
        M.add("Minor Test:-"
                + "\nThe Minor test (starch-iodine test) described by Minor in 1928[1] is a qualitative test used to evaluate sudomotor function (sweating).\nMethod\nAn iodine solution is applied to the skin and allowed to air-dry. Once dry the area is dusted with cornstarch or potato flour. Sweating is then encouraged with the aid of pilocarpine, the use of a sauna or exercise.\nWhen sweat reaches the surface of the skin the starch and iodine combine causing a dramatic color change (yellow -> dark blue) allowing sweat production to be actively visualized.\nUses\nThe minor test can be used as a diagnostic tool to evaluate underactive (hypohidrosis)[2] and overactive (hyperhidrosis) sweating.");
        M.add("Mitotic Index:-"
                + "\nMitotic index is a measure for the proliferation status of a cell population. It is defined as the ratio between the number of cells in mitosis and the total number of cells.");
        M.add("Molecular Diagnostics:-"
                + "\nMolecular diagnostics is a technique used to analyse biological markers in the genome and proteome—the individual's genetic code and how their cells express their genes as proteins—by applying molecular biology to medical testing. The technique is used to diagnose and monitor disease, detect risk, and decide which therapies will work best for individual patients.");
        M.add("Molecular Reference Standards:-"
                + "\nMolecular/Genomic reference standards are a class of ‘controls’ or standards used to check the performance of molecular diagnostic assays. Molecular/Genomic Reference Materials (RMs) are selected or engineered to model a specific genetic biomarker as it occurs in a patient biopsy. Reference materials (RM) are used for a calibration of the measuring system, for assessment of a measurement procedure, for assigning values to materials, or for quality control.");
        M.add("Multifocal Technique:-"
                + "\nMultifocal techniques are used in electroretinogram and visual evoked potential recordings to separate the responses originating from the stimulation of different locations in the visual field (and thus different retinal locations).\nThe concept is as follows: Each visual field location is stimulated with a stimulus sequence that is uncorrelated to the sequences used for the other locations. All visual field locations are stimulated in parallel with their individual stimulus sequence. The retinal or cortical activity, which is a mixture of the responses from all visual field locations, is recorded with usual electroretinographic or visual evoked potential methods, respectively. Due to the independence of the stimulus sequences, the responses for each visual field location can be extracted using mathematical algorithms.");
        M.add("Multiple Of The Median:-"
                + "\nA multiple of the median (MoM) is a measure of how far an individual test result deviates from the median. MoM is commonly used to report the results of medical screening tests, particularly where the results of the individual tests are highly variable.\nMoM was originally used as a method to normalize data from participating laboratories of Alpha-fetoprotein (AFP) so that individual test results could be compared. 35 years later, it is the established standard for reporting maternal serum screening results.");

        List<String> N = new ArrayList<String>();
        N.add("Nano-tetherball Sensor:-"
                + "\nNano-tetherball Sensor is one of newly discovered methods in detecting glucose in the human body. Nano-tetherball Sensor for Glucose has attracted attention of diabetic medical community due to its methods and high sensitivity in performance. The machine’s name comes from the fact that its design is similar to a small cube-shaped tetherball. Nano machines have been in the biosensor industry for more than two decades, and they have performed a number of different beneficial roles for diabetic patients. Despite the many opto/electronic mechanisms on the market, from a physical and chemical point of view, the nanomachine optical fiber provides many advantages over the other types.");
        N.add("Nardi Test:-"
                + "\nThe Nardi test, also known as the morphine-neostigmine provocation test is a test for dysfunction of the sphincter of Oddi, a valve which divides the biliary tract from the duodenum. Two medications, morphine and neostigmine, are given to people with symptoms concerning for sphincter dysfunction, including sharp right-sided abdominal pain. If the pain is reproduced by the medications, then dysfunction is more likely. The test poorly predicts dysfunction, however, and is rarely used today. The Nardi test was named for George Nardi, who first described the procedure in 1966.");
        N.add("NEFERT:-"
                + "\nNEFERT (Neck Flexion Rotation Test) is a medical examination procedure developed in 1999 by German neurootologist Claus-Frenz Claussen.");
        N.add("Neurofeedback:-"
                + "\nNeurofeedback (NFB), also called neurotherapy or neurobiofeedback, is a type of biofeedback that uses real-time displays of brain activity—most commonly electroencephalography (EEG), to teach self-regulation of brain function. Typically, sensors are placed on the scalp to measure activity, with measurements displayed using video displays or sound.");
        N.add("Neutrophil Oxidative Index:-"
                + "\nNeutrophil Oxidative Burst Test (or Chronic Granulomatous Disease (CGD) Test) is a measure of neutrophil oxidation is a useful assay in the diagnosis of chronic granulomatous disease and is also a useful means to determine the overall metabolic integrity of phagocytosing neutrophils. The NADPH oxidase enzyme is missing in CGD. From total blood, neutrophils can be purified and the NADPH oxidase activity can be measured with different methods in these cells after activation. Phagocytosis by polymorphonuclear neutrophils and monocytes constitutes an essential arm of host defense against bacterial or fungal infections. The phagocytic process can be separated into several major stages: chemotaxis (migration of phagocytes to inflammatory sites), attachment of particles to the cell surface of phagocytes, ingestion (phagocytosis) and intracellular killing by oxygen-dependent (oxidative burst) and oxygen-independent mechanisms.");
        N.add("Nitrogen Washout:-"
                + "\nNitrogen washout (or Fowler's method) is a test for measuring dead space in the lung during a respiratory cycle, as well as some parameters related to the closure of airways.");

        List<String> O = new ArrayList<String>();
        O.add("Oncotype DX:-"
                + "\nOncotype DX, developed by Genomic Health, is a diagnostic test that quantifies the likelihood of disease recurrence in women with early-stage hormone estrogen receptor (ER) positive only breast cancer (prognostic significance) and assesses the likely benefit from certain types of chemotherapy (predictive significance).");
        O.add("Oncotype DX Colon Cancer Assay:-"
                + "\nhe Oncotype DX Colon Cancer Assay, developed by Genomic Health, is a genomic test that has been clinically available for patients with newly diagnosed stage II colon cancer, since January 2010. The test is a validated diagnostic assay based on an individual patient’s colon tumor expression of 12 genes, which quantifies the likelihood of recurrence in stage II colon cancer following surgery. The result from the assay is a continuous Recurrence Score® value from 0 to 100 that corresponds to a specific likelihood of colon cancer recurrence 3 years after surgery. A lower score corresponds to a lower risk of recurrence, and a higher score corresponds to a higher risk of recurrence. The Recurrence Score result provides additional information on recurrence risk beyond traditional clinical and pathological characteristics such as tumor stage (T-stage), mismatch repair (MMR) status, number of lymph nodes examined, tumor grade and lymphovascular invasion.");
        O.add("OraQuick (STD test):-"
                + "\nOraQuick is a home HIV test approved by the United States Food and Drug Administration in 2012 and released for sale over the counter later that same year.\nThe test is performed by taking an oral swab of the inside of the human mouth and reported to show results within twenty minutes.");
        O.add("Overscreening:-"
                + "\nOverscreening, also called unnecessary screening, is the performance of medical screening without a medical indication to do so. Screening is a medical test in a healthy person who is showing no symptoms of a disease and is intended to detect a disease so that a person may prepare to respond to it. Screening is indicated in people who have some threshold risk for getting a disease, but is not indicated in people who are unlikely to develop a disease. Overscreening is a type of unnecessary health care.\nOverscreening is problematic because it can lead to risky or harmful additional treatment when a healthy person gets a false positive result for screening which they should not have had. It also causes unnecessary stress for the person receiving the test, and it brings unnecessary financial costs which someone pays.");

        List<String> P = new ArrayList<String>();
        P.add("Pack-Year:-"
                + "\nA pack-year is a quantification of cigarette smoking.\nThe pack-year is a unit for measuring the amount a person has smoked over a long period of time. It is calculated by multiplying the number of packs of cigarettes smoked per day by the number of years the person has smoked. For example, 1 pack-year is equal to smoking 20 cigarettes (1 pack) per day for 1 year, or 40 cigarettes per day for half a year, and so on.\nOne pack-year is the equivalent of 365.24 packs of cigarettes or 7,305 cigarettes.");
        P.add("Pap Test:-"
                + "\nThe Papanicolaou test (abbreviated as Pap test, known earlier as Pap smear, cervical smear, or smear test) is a method of cervical screening used to detect potentially pre-cancerous and cancerous processes in the endocervical canal (transformation zone) of the female reproductive system. Unusual findings are often followed up by more sensitive diagnostic procedures, and, if warranted, interventions that aim to prevent progression to cervical cancer. The test was invented by and named after the prominent Greek doctor Georgios Papanikolaou.");
        P.add("Peanut Butter Test:-"
                + "\nThe peanut butter test is a diagnostic test which aims to detect Alzheimer's disease by measuring subjects' ability to smell peanut butter through each nostril. The test was originally reported in October 2013 by researchers from the University of Florida's McKnight Brain Institute, led by professor Kenneth Heilman, and involves measuring the ability of patients to smell peanut butter held close to their nose. The researchers concluded that patients with Alzheimer's were not able to smell the peanut butter as well through their left nostril as their right one.[1] The study's lead author, graduate student Jennifer Stamps, got the idea for the study when, while studying under Professor Heilman, she noticed that none of his patients had been tested for their sense of smell. The idea of using peanut butter came to Stamps when she administered it to patients as part of a routine test of cranial nerve function.[2] Their decision to use it was also motivated by the fact that it is a pure odorant (i.e. is only detected by the olfactory nerve), and that Heilman had told Stamps, \"If you can come up with something quick and inexpensive, we can do it.\"");
        P.add("Perfusion Scanning:-"
                + "\nPerfusion is defined as the passage of fluid through the lymphatic system or blood vessels to an organ or a tissue. The practice of perfusion scanning, is the process by which this perfusion can be observed, recorded and quantified. The term perfusion scanning encompasses a wide range of medical imaging modalities.");
        P.add("Peritoneal Equilibration Test:-"
                + "\nIn nephrology, the peritoneal equilibration test (PET), is a tool used by nephrologists to determine the characteristics of the peritoneal membrane mass transport characteristics, when assessing a patient for peritoneal dialysis.");
        P.add("Phi Complex:-"
                + "\nThe phi complex is a brain rhythm in the awake human brain that appears to serve various social functions. Phi is one of several brain rhythms in the awake human brain that coordinate human behavior. \"Phi\" operates in the 10-Hz band (ten oscillations per second), and is located above the right centro-parietal cortex. It consists of two components, one favoring independent behaviors, and the other favoring interpersonal coordination between people.\nThe brain wave patterns of the phi complex are consistent with those of waves produced in the human mirror neuron system. The phi complex may reflect the influence of one person upon another's behavior, with phi-1 expressing the inhibition of the human mirror neuron system and phi-2 its enhancement.");
        P.add("Phonocardiogram:-"
                + "\nA Phonocardiogram or PCG is a plot of high fidelity recording of the sounds and murmurs made by the heart with the help of the machine called phonocardiograph, or \"Recording of the sounds made by the heart during a cardiac cycle.\" The sounds are thought to result from vibrations created by closure of the heart valves. There are at least two: the first when the atrioventricular valves close at the beginning of systole and the second when the aortic valve and pulmonary valve close at the end of systole. It allows the detection of subaudible sounds and murmurs, and makes a permanent record of these events. In contrast, the ordinary stethoscope cannot detect such sounds or murmurs, and provides no record of their occurrence. The ability to quantitate the sounds made by the heart provides information not readily available from more sophisticated tests, and provides vital information about the effects of certain cardiac drugs upon the heart. It is also an effective method for tracking the progress of the patient's disease.");
        P.add("Phonomyography:-"
                + "\nPhonomyography (PMG) (also known as acoustic myography, sound myography, vibromyography, and surface mechanomyogram) is a technique to measure the force of muscle contraction by recording the low frequency sounds created during muscular activity.");
        P.add("Point-of-care Genetic Testing:-"
                + "\nPoint-of-care genetic testing incorporates the newest most sophisticated techniques to identify variations in the genetic sequence at the bedside – enabling clinicians to react and alter therapy based upon the results.");
        P.add("Point-of-care Testing:-"
                + "\nPoint-of-care testing (POCT), or bed-side testing is defined as medical testing at or near the site of patient care. These are simple medical blood tests which can be performed at the bedside. Simple tests such as those found in medical examinations, urine test strips and even simple imaging such as with a portable ultrasound device. As well as regular observations such as ECG's, O2 saturation and heart rate.");
        P.add("Poppy Seed Test (medical sign):-"
                + "\nIn medicine, the poppy seed test is a diagnostic test used before surgery to predict if surgery will find a vesicointestinal fistula or colovesical fistula (an abnormal direct pathway between the colon and urinary bladder) or other type of vesicointestinal fistula.");
        P.add("Porges-Meier Reaction:-"
                + "\nPorges-Meier reaction is a precipitation test used in the diagnosis of syphilis.\nIt is an early flocculation test for syphilis.");
        P.add("Postage Stamp Test;-"
                + "\nThe Postage stamp test is a test used to evaluate nocturnal erections in a workup of male impotence. A length of connected postage stamps connected by perforations that allow easy tearing are secured loosely around the male's flaccid penis just prior to sleeping. If the perforated connections between the individual stamps are torn upon awakening, this is taken as evidence of nocturnal tumescence. However, there is also a chance that the male may shift his position in bed in such a way as to unknowingly tear the perforated connections between the stamps without having achieved a nocturnal erection, thus causing a false positive.");
        P.add("Postcoital Test:-"
                + "\nThe postcoital test (PCT) (also known as Sims test, Huhner test or Sims-Huhner test) is a test in the evaluation of infertility. The test examines interaction between sperm and mucus of the cervix.");
        P.add("Prausnitz–Küstner test:-"
                + "\nThe Prausnitz-Küstner test (PK test, Prausnitz-Küstner reaction) is an immunologic test formerly used by physicians to determine if a patient has an allergic reaction to a specific antigen.[1] The test has been replaced by the safer skin prick test. The PK test involves transferring serum from the test subject to another healthy person, essentially using the second person as a mixing vessel for antibodies and antigen. This is a pathway for transmission of blood-borne diseases like Creutzfeldt–Jakob disease, AIDS, and others, which is why the test is no longer recommended. Or in simple words, a test for the presence of immediate hypersensitivity in humans; test serum from an atopic individual is injected intradermally into a normal subject; the normal subject is challenged 24–48 hours later with the antigen suspected of causing the immediate hypersensitivity reaction in the atopic individual.");
        P.add("Predictive Testing:-"
                + "\nPredictive testing is a form of genetic testing. It is also known as presymptomatic testing. These types of testing are used to detect gene mutations associated with disorders that appear after birth, often later in life. These tests can be helpful to people who have a family member with a genetic disorder, but who have no features of the disorder themselves at the time of testing. Predictive testing can identify mutations that increase a person's risk of developing disorders with a genetic basis, such as certain types of cancer. For example, an individual with a mutation in BRCA1 has a 65% cumulative risk of breast cancer. Presymptomatic testing can determine whether a person will develop a genetic disorder, such as hemochromatosis (an iron overload disorder), before any signs or symptoms appear. The results of predictive and presymptomatic testing can provide information about a person’s risk of developing a specific disorder and help with making decisions about medical care.");
        P.add("Predictive Value Of Tests:-"
                + "\nPredictive value of tests is the probability of a target condition (for example a disease) given by the result of a test, often in regard to medical test");
        P.add("Preferential Hyperacuity Perimetry:-"
                + "\nPreferential hyperacuity perimetry is a psychophysical test used to identify and quantify visual abnormalities such as metamorphopsia and scotoma. It is a type of perimetry.");
        P.add("Pulmonary Wedge Pressure:-"
                + "\nThe pulmonary capillary wedge pressure or PCWP (also called the pulmonary wedge pressure or PWP, or pulmonary artery occlusion pressure or PAOP) or cross-sectional pressure, is the pressure measured by wedging a pulmonary catheter with an inflated balloon into a small pulmonary arterial branch.");
        P.add("Pulse Oximetry:-"
                + "\nPulse oximetry is a non-invasive method for monitoring a person's O2 saturation.\nIn its most common (transmissive) application mode, a sensor device is placed on a thin part of the patient's body, usually a fingertip or earlobe, or in the case of an infant, across a foot. The device passes two wavelengths of light through the body part to a photodetector. It measures the changing absorbance at each of the wavelengths, allowing it to determine the absorbances due to the pulsing arterial blood alone, excluding venous blood, skin, bone, muscle, fat, and (in most cases) nail polish.");

        List<String> R = new ArrayList<String>();
        R.add("Rapid Diagnostic Test:-"
                + "\nA rapid diagnostic test (RDT) is a medical diagnostic test that is quick and easy to perform. RDTs are suitable for preliminary or emergency medical screening and for use in medical facilities with limited resources. They provide same-day results within two hours, typically in approximately 20 minutes.");
        R.add("Rapid Strep Test:-"
                + "\nThe Rapid strep test (RST), or rapid antigen detection test (RADT), is a rapid diagnostic test that is widely used in clinics to assist in the diagnosis of bacterial pharyngitis caused by group A streptococci (GAS), sometimes termed strep throat. There are currently several types of rapid strep test in use, each employing a distinct technology. However, they all work by detecting the presence of GAS in the throat of a patient by responding to GAS-specific antigens on a throat swab.");
        R.add("Rapid Urease Test:-"
                + "\nRapid urease test, also known as the CLO test (Campylobacter-like organism test), is a rapid diagnostic test for diagnosis of Helicobacter pylori. The basis of the test is the ability of H. pylori to secrete the urease enzyme, which catalyzes the conversion of urea to ammonia and carbon dioxide.");
        R.add("Reaction Agostini:-"
                + "\nReaction Agostini is the name of a simplified examination for the presence of glucose in human urine.\nThe method consists of preparing a solution of sodium chloride and potassium oxide, adding the urine to be investigated. If there is glucose present, the solution becomes red.");
        R.add("Rectal Thermometry:-"
                + "\nRectal thermometry is an umbrella term covering the practice, widely used in modern medicine and science, of taking a mammal's temperature by inserting a thermometer into the aforementioned mammal's rectum via the anus. This is generally regarded as the most accurate means of temperature-taking, but some may consider it to be an invasive or humiliating procedure. Thus, it is often used sparingly and primarily on infants, children or adults for whom taking an oral temperature would risk injury (e.g. an unconscious patient, a post-oral surgery patient, or a person suffering a seizure) or be inaccurate (due to recently ingested liquids or breathing through the mouth).");
        R.add("Rivalta Test:-"
                + "\nRivalta’s test is a very simple, inexpensive method that does not require special laboratory equipment and can be easily performed in private practice. This test was originally developed by the Italian researcher Rivalta around 1900 and was used to differentiate transudates and exudates in human patients. This test is very useful in cats to differentiate between effusions due to FIP and effusions caused by other diseases [Hartmann et al., 2003]. Not only the high protein content, but high concentrations of fibrinogen and inflammatory mediators lead to a positive reaction.");

        List<String> S = new ArrayList<String>();
        S.add("Saliva Hormone Testing:-"
                + "\nSaliva hormone testing is an effort to determine the amount of hormones found in saliva. Though promoted as an accurate way of determining hormone levels in the body, it does not represent either the amount of hormones in the blood, or their biological activity. Saliva testing is often used as part of bioidentical hormone replacement therapy, though it has been criticized for being expensive, unnecessary and meaningless.");
        S.add("Saliva Testing:-"
                + "\nSaliva testing is a diagnostic technique that involves laboratory analysis of saliva to identify markers of endocrine, immunologic, inflammatory, infectious, and other types of conditions. Saliva is a useful biological fluid for assaying steroid hormones such as cortisol, genetic material like RNA, proteins such as enzymes and antibodies, and a variety of other substances, including natural metabolites, including saliva nitrite, a biomarker for nitric oxide status (see below for Cardiovascular Disease, Nitric Oxide: a salivary biomarker for cardio-protection). Saliva testing is used to screen for or diagnose numerous conditions and disease states, including Cushing's disease, anovulation, HIV, cancer, parasites, hypogonadism, and allergies.");
        S.add("Scanning Laser Polarimetry:-"
                + "\nScanning laser polarimetry is the use of polarised light to measure the thickness of the retinal nerve fiber layer as part of a glaucoma workup. ");
        S.add("Schiller's Test:-"
                + "\nSchiller's test or Schiller's Iodine test is a medical test in which iodine solution is applied to the cervix in order to diagnose cervical cancer.");
        S.add("Screening (medicine):-"
                + "\nScreening, in medicine, is a strategy used in a population to identify an unrecognized disease in individuals without signs or symptoms. This can include individuals with pre-symptomatic or unrecognized symptomatic disease. As such, screening tests are somewhat unique in that they are performed on persons apparently in good health.");
        S.add("Screening Cultures:-"
                + "\nScreening culture is a type a medical test that is done to find an infection. Screening cultures are often performed to find infections that do not have signs and symptoms.");
        S.add("Scripps Genomic Health Initiative:-"
                + "\nThe Scripps Genomic Health Initiative (SGHI) is a ground-breaking study aimed at understanding how personal genetic testing influences and improves health.");
        S.add("Secretin-Cholecystokinin Test:-"
                + "\nThe secretin-cholecystokinin test (secretin-CCK test) is a combination of the secretin test and the cholecystokinin test and is used to assess the function of both the pancreas and gall bladder. Cholecystokinin, a hormone secreted by the APUD cells located in the proximal mucosa of the small intestine is administered intravenously, this stimulates the pancreatic secretion of the digestive enzymes amylase, trypsin, and lipase.");
        S.add("Sereny Test:-"
                + "\nThe Sereny test is a test used to test the invasiveness of organisms such as Escherichia coli.");
        S.add("Serum-Ascites Albumin Gradient:-"
                + "\nThe serum-ascites albumin gradient or gap (SAAG) is a calculation used in medicine to help determine the cause of ascites.");
        S.add("Sitting-Rising Test:-"
                + "\nThe sitting-rising test is an easy-to-administer test which provides a significant and efficient prediction of mortality risk in elders. It was initially developed in the 1990s. In one study of subjects between the ages of 51 and 80, those who had the lowest score range were 5-6 times more likely to die within the study period (about 6 years) than those in the group with the highest scores.");
        S.add("Sperm–Cervical Mucus Contact Test;-"
                + "\nThe sperm–cervical mucus contact test is an in-vitro slide test used for detecting antispermal antibodies. It is one of the investigations done for infertility. It should not be confused with Kurzrock–Miller test, where there is interface between the two materials; whereas in this test the materials are thoroughly mixed.");
        S.add("Sputum Culture:-"
                + "\nA sputum culture is a test to detect and identify bacteria[1] or fungi that infect the lungs or breathing passages. Sputum is a thick fluid produced in the lungs and in the adjacent airways. A sample of sputum is placed in a sterile container and sent to the laboratory for testing. ");
        S.add("Stethoscope:-"
                + "\nThe stethoscope is an acoustic medical device for auscultation, or listening to the internal sounds of an animal or human body. It is often used to listen to lung and heart sounds. It is also used to listen to intestines and blood flow in arteries and veins. In combination with a sphygmomanometer, it is commonly used for measurements of blood pressure. ");
        S.add("String Galvanometer:-"
                + "\nThe string galvanometer was one of the earliest instruments capable of detecting and recording the very small electrical currents produced by the human heart and provided the first practical Electrocardiogram (ECG). The original machines achieved \"such amazing technical perfection that many modern day electrocardiographs do not attain equally reliable and undistorted recordings\".");
        S.add("Structured Light Plethysmography:-"
                + "\nStructured Light Plethysmography (SLP) technology utilises pc gaming/movie techniques to scan a patient with visible light, capture an image, measure movement in the image and produce accurate, real time data on changes in respiration. A checker board pattern of light is projected from a light projector onto the chest of an individual. Movements of the grid are viewed by two digital cameras, digitalised, and processed to form a 3D model and can be interrogated to assess lung function.");
        S.add("Sucrose Gap:-"
                + "\nThe sucrose gap technique is used to create a conduction block in nerve or muscle fibers. A high concentration of sucrose is applied to the extracellular space to increase resistance between two groups of cells, which prevents the correct opening and closing of sodium and potassium channels.");
        S.add("Surround Optical Fiber Immunoassay:-"
                + "\nSurround optical fiber immunoassay (SOFIA) is an ultrasensitive, in vitro diagnostic platform incorporating a surround optical fiber assembly that captures fluorescence emissions from an entire sample. The technology's defining characteristics are its extremely high limit of detection, sensitivity, and dynamic range. SOFIA’s sensitivity is measured at the attogram level (10−18g), making it about one billion times more sensitive than conventional diagnostic techniques. Based on its enhanced dynamic range, SOFIA is able to discriminate levels of analyte in a sample over 10 orders of magnitude, facilitating accurate titering.");
        S.add("Swedish Interactive Thresholding Algorithm:-"
                + "\nUsually referred to as SITA, the 'Swedish interactive thresholding algorithm is a method to test for visual field loss, usually in glaucoma testing or monitoring. It is combined with a visual field test such as standard automated perimetry (SAP) or short wavelength automated perimetry (SWAP) to determine visual fields in a more efficient manner.");
        List<String> T = new ArrayList<String>();
        T.add("Tecumseh Step Test:-"
                + "\nThe Tecumseh step test is a modified version of the Harvard Step Test developed by Professor Henry J. Montoye. The main differences from the original protocol were the lower step height (8 inches instead of 20), the more moderate stepping rate (24 steps/min instead of 30) and the shorter duration (3 minutes instead of 5 minutes). These alterations made this test easier to perform and suitable for epidemiological studies.");
        T.add("Temperature Measurement:-"
                + "\nAttempts of standardized temperature measurement have been reported as early as 170 AD by Claudius Galenus.[1] The modern scientific field has its origins in the works by Florentine scientists in the 17th century. Early devices to measure temperature were called thermoscopes. The first sealed thermometer was constructed in 1641 by the Grand Duke of Toscani, Ferdinand II.[1] The development of today's thermometers and temperature scales began in the early 18th century, when Gabriel Fahrenheit adapted a thermometer using mercury and a scale both developed by Ole Christensen Rømer. Fahrenheit's scale is still in use, alongside the Celsius scale and the Kelvin scale.");
        T.add("Tensiomyography:-"
                + "\nensiomyography (TMG) is a unique non invasive technological procedure that facilitates the measurement of the contractile properties of superficial skeletal muscles. Originally designed for use by medical professionals, TMG has successfully transitioned from medicine, through sports medicine and is now being effectively utilized in sports training programs and post trauma rehabilitation.");
        T.add("Test panel:-"
                + "\nA test panel is a predetermined group of medical tests as an aid in the diagnosis and treatment of disease.\nTest panels (sometimes called profiles) are typically composed of individual laboratory tests which are related in some way: by the medical condition they are intended to help diagnose (cardiac risk panel), by the specimen type (complete blood count, CBC), by the tests most frequently requested by users (comprehensive chemistry profile), by the methodology employed in the test (viral panel by polymerase chain reaction), or by the types of components included (urine drug screen).");
        T.add("Thoracentesis:-"
                + "\nThoracentesis is an invasive procedure to remove fluid or air from the pleural space for diagnostic or therapeutic purposes. A cannula, or hollow needle, is carefully introduced into the thorax, generally after administration of local anesthesia. The procedure was first described in 1852.");
        T.add("Throat Culture:-"
                + "\nA throat culture is a laboratory diagnostic test that evaluates for the presence of a bacterial or fungal infection in the throat. A sample from the throat is collected by swabbing the throat and placing the sample into a special cup (culture) that allows infections to grow. If an organism grows, the culture is positive and the presence of an infection is confirmed. The type of infection is found using a microscope, chemical tests, or both. If no infection grows, the culture is negative. ");
        T.add("Timed Up And Go Test:-"
                + "\nThe Timed Up and Go test (TUG) is a simple test used to assess a person's mobility and requires both static and dynamic balance.\nIt uses the time that a person takes to rise from a chair, walk three metres, turn around, walk back to the chair, and sit down. During the test, the person is expected to wear their regular footwear and use any mobility aids that they would normally require. The TUG is used frequently in the elderly population, as it is easy to administer and can generally be completed by most older adults.");
        T.add("Tissue Typing:-"
                + "\nTissue typing is a procedure in which the tissues of a prospective donor and recipient are tested for compatibility prior to transplantation. An embryo can be tissue typed to ensure that the embryo implanted can be a cord-blood stem cell donor for a sick sibling.");
        T.add("Tobey–Ayer Test:-"
                + "\nThe Tobey–Ayer test is used for lateral sinus thrombosis by monitoring cerebrospinal fluid pressure during a lumbar puncture. No increase of cerebrospinal fluid pressure during compression of the internal jugular vein on the affected side, and an exaggerated response on the patent side, is suggestive of lateral sinus thrombosis.");
        T.add("Tomography:-"
                + "\nTomography refers to imaging by sections or sectioning, through the use of any kind of penetrating wave. A device used in tomography is called a tomograph, while the image produced is a tomogram. Tomography as the computed tomographic (CT) scanner was invented by Sir Godfrey Hounsfield, and thereby made an exceptional contribution to medicine. The method is used in radiology, archaeology, biology, atmospheric science, geophysics, oceanography, plasma physics, materials science, astrophysics, quantum information, and other sciences. In most cases it is based on the mathematical procedure called tomographic reconstruction.");
        T.add("Tourniquet Test:-"
                + "\nA tourniquet test (also known as a Rumpel-Leede capillary-fragility test or simply a capillary fragility test) determines capillary fragility. It is a clinical diagnostic method to determine a patient's haemorrhagic tendency. It assesses fragility of capillary walls and is used to identify thrombocytopenia (a reduced platelet count).");
        T.add("Transcranial Doppler:-"
                + "\nThe Transcranial Doppler (TCD) and the more recent Transcranial Color Doppler (TCCD) are tests that measure the velocity of blood flow through the brain's blood vessels. Used to help in the diagnosis of emboli, stenosis, vasospasm from a subarachnoid hemorrhage (bleeding from a ruptured aneurysm), and other problems, this relatively quick and inexpensive test is growing in popularity in the United States. TCD is effective to detect sickle cell disease, (in order) established for ischemic cerebrovascular disease, subarachnoid hemorrhage, arteriovenous malformations and cerebral circulatory arrest and possibly useful for perioperative monitoring and menigeal infection. The equipment used for these tests is becoming increasingly portable, making it possible for a clinician to travel to a hospital, doctor's office or nursing home for both inpatient and outpatient studies. It is often used in conjunction with other tests such as MRI, MRA, carotid duplex ultrasound and CT scans.");
        T.add("Trinder glucose activity test:-"
                + "\nThe Trinder glucose activity test is a diagnostic test used in medicine to determine the presence of glucose or glucose oxidase. The test employs the Trinder reagent, and is a colour change test resulting from the Trinder reaction.");
        T.add("Trinder Spot Test:-"
                + "\nThe Trinder spot test is a diagnostic test used in medicine to determine exposure to salicylates, particularly to salicylic acid. The test employs the Trinder reagent (a.k.a. Trinder solution) which is mixed with a patient's urine. The colour change, resulting from the Trinder reaction, is immediate, enabling rapid bedside assessment.");
        T.add("Tympanometry:-"
                + "\nTympanometry is an examination used to test the condition of the middle ear and mobility of the eardrum (tympanic membrane) and the conduction bones by creating variations of air pressure in the ear canal.");
        T.add("Tzanck Test:-"
                + "\nIn dermatopathology, the Tzanck test, also Tzanck smear, is scraping of an ulcer base to look for Tzanck cells. It is sometimes also called the Chickenpox skin test and the herpes skin test.");

        List<String> V = new ArrayList<String>();
        V.add("Veristrat:-"
                + "\nVeristrat is a test aiming at predicting benefit from canceer treatment by EGFR inhibitors. It is a serum/plasma proteomic test developed using matrix-assisted laser desorption/ionization (MALDI) mass spectrometry.");
        V.add("Viral Culture:-"
                + "\nViral culture is a laboratory test in which samples are placed with a cell type that the virus being tested for is able to infect. If the cells show changes, known as cytopathic effects, then the culture is positive.");
        V.add("Viral Load:-"
                + "\nViral load, also known as viral burden, viral titre or viral titer, is a measure of the severity of an active viral infection, and can be calculated by estimating the live amount of virus in an involved body fluid. For example, it can be given in RNA copies per millilitre of blood plasma. Tracking viral load is used to monitor therapy during chronic viral infections, and in immunocompromised patients such as those recovering from bone marrow or solid organ transplantation. Currently, routine testing is available for HIV-1, cytomegalovirus, hepatitis B virus, and hepatitis C virus.");
        V.add("Virus Counter:-"
                + "\nThe Virus Counter is an instrument for rapid quantification of viruses in liquid samples. It is a specialized flow cytometer that uses high-sensitivity fluorescence detection to give a direct measurement of the concentration of virus particles in a fraction of the time required for traditional plaque assays.");
        List<String> Y = new ArrayList<String>();
        Y.add("Yergason's Test:-"
                + "\nYergason's test is a special test used for orthopedic examination of the shoulder and upper arm region, specifically the biceps tendon.");
        listDataChild.put(listDataHeader.get(0), A); // Header, Child data
        listDataChild.put(listDataHeader.get(1), B);
        listDataChild.put(listDataHeader.get(2), C);
        listDataChild.put(listDataHeader.get(3), D);
        listDataChild.put(listDataHeader.get(4), E);
        listDataChild.put(listDataHeader.get(5), F);
        listDataChild.put(listDataHeader.get(6), G);
        listDataChild.put(listDataHeader.get(7), H);
        listDataChild.put(listDataHeader.get(8), I);
        listDataChild.put(listDataHeader.get(9), K);
        listDataChild.put(listDataHeader.get(10), L);
        listDataChild.put(listDataHeader.get(11), M);
        listDataChild.put(listDataHeader.get(12), N);
        listDataChild.put(listDataHeader.get(13), O);
        listDataChild.put(listDataHeader.get(14), P);
        listDataChild.put(listDataHeader.get(15), R);
        listDataChild.put(listDataHeader.get(16), S);
        listDataChild.put(listDataHeader.get(17), T);
        listDataChild.put(listDataHeader.get(18), V);
        listDataChild.put(listDataHeader.get(19), Y);
    }

}
