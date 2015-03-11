package corp.mahisan.medicinastore;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by user on 13-02-2015.
 */
public class Fetch_Medicine extends ActionBarActivity implements View.OnClickListener {
    Animation animFadein;
    AutoCompleteTextView act;
    ArrayAdapter<String> adapter;
    Button bt , listen;
    Toolbar toolbar;
    public TextView tv;
    public TextToSpeech ttobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fetch_medicine);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Prescribe Medicine");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        act = (AutoCompleteTextView) findViewById(R.id.act);
        act.setRawInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        bt = (Button) findViewById(R.id.button1);
        tv = (TextView) findViewById(R.id.tv1);
        listen = (Button) findViewById(R.id.btnListen);
        tv.setMovementMethod(new ScrollingMovementMethod());
        String[] colors = getResources().getStringArray(R.array.colorList);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,colors);
        act.setAdapter(adapter);
        act.setThreshold(1);
        // load the animation
        animFadein = AnimationUtils.loadAnimation(this,
                R.anim.fade_in);

        ttobj=new TextToSpeech(this,
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            ttobj.setLanguage(Locale.UK);
                        }
                    }
                });
        listen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String toSpeak = tv.getText().toString();
                //Toast.makeText(getActivity(), toSpeak, Toast.LENGTH_SHORT).show();
                AlertDialog.Builder viewDetail = new AlertDialog.Builder(Fetch_Medicine.this);
                viewDetail.setIcon(R.drawable.pause);
                viewDetail.setTitle("Stop Speak");
                viewDetail.setMessage(toSpeak);
                viewDetail.setPositiveButton("Dismiss",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
// TODO Auto-generated method stub
                                ttobj.stop();

                                dialog.dismiss();
                            }
                        });
                viewDetail.show();
                ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        bt.setOnClickListener(this);

    }
    @Override
    public void onPause(){
        if(ttobj !=null){
            ttobj.stop();
        }
        super.onPause();
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        String bucket = act.getText().toString();
        tv.setScrollY(0);
        tv.startAnimation(animFadein);
        if ("fever".equals(bucket)){

            tv.setText("1)ACETAMINOPHEN:-" +
                    "\nThe oral dose for adults is 325 to 650 mg every 4 to 6 hours. The maximum daily dose is 4 grams.\nChild- the recommended dose is 10 to 15 mg/kg every 4 to 6 hours." +
                    "\n2)ASPIRIN:-" +
                    "\nAdult: PO- Prophylaxis of MI- 75-325 mg/day.\nStent implantation -325 mg 2 hr pre-op, then 160-325 mg/day.\nPain and fever- 325-650 mg 4-6 hourly.\n Max: 4 g/day.Pain and inflammation associated with musculoskeletal and joint disorders -Initial: 2.4-3.6 g/day.\n Maintenance: 3.6-5.4 g/day." +
                    "\n3)IBUPROFEN:-" +
                    "\nThe recommended dose range is 200 to 600mg 4-6 hourly. Max: 1.2 g/day" +
                    "\n4)PARACETAMOL:-" +
                    "\nYou can take a dose of paracetamol every 4-6 hours if needed, but do not take more than four doses in any 24-hour period" +
                    "\n5)NAPROXEN:-" +
                    "\nAdult: PO- 0.5-1 g in 1-2 divided doses. Up to 1.5 g/day in patients who can tolerate lower doses.");
        }
        else if("chickenpox".equals(bucket)){

            tv.setText("The varicella vaccine is a live (attenuated) virus administered to protect against the viral disease commonly known as chickenpox caused by the varicella zoster virus (VZV).");
        }
        else if("cold".equals(bucket)){
            tv.setText("1)Aspirin and Codeine:-" +
                    "\nDose is based on patient’s condition and response to the medication.Adult- The recommended dose for aspirin 325mg and codeine 30 mg is one or two tablets every four hour." +
                    "\n2)Benzonatate:-" +
                    "\nChildren over age of 10 and Adults- The usual dose is a 100-milligram perle 3 times per day, as needed. The maximum dose is 600 milligrams, or 6 perles, a day." +
                    "\n3)Oxymetazoline:-" +
                    "\nAdult: Nasal congestion- As 0.05% solution: Spray 1-3 doses into each nostril twice daily." +
                    "\n4)Triprolidine:-" +
                    "\nAdult: PO- The recommended dose is 2.5 mg 4-6 hourly. Max: 10 mg/day.");
        }
        else if("muscle pain".equals(bucket)){
            tv.setText("1)Carisoprodol (Soma):-" +
                            "\nThis drug's dosage is 350mg every eight hours as needed for muscle spasm." +
                            "\n2)Cyclobenzaprine (Flexeril):-" +
                            "\nGet prescribed by doctor." +
                            "\n3)Diazepam (Valium):-" +
                            "\nValium is usually limited to one to two weeks of use, and the typical dosage is 5-10 mg every six hours as needed to relieve low back pain associated with muscle spasm." +
                            "\n4)Volini Spray:-" +
                            "\nDirectly Apply on the Pain part 4 times a day"
            );
        }
        else if("headache".equals(bucket)){
            tv.setText("1)Metaxalone:-" +
                    "\nGet Prescribed Dose from doctor" +
                    "\n2)Disprin:-" +
                    "\ntwo tablets per day..Pregnant women should not risk to take it" +
                    "\n3)Fenoprofen:-" +
                    "\nGet Prescribed Dose from doctor" +
                    "\n4)Ibuprofen:-" +
                    "\nGet Prescribed Dose from doctor");
        }
        else if("pimples".equals(bucket)){
            tv.setText("1)Avene Diacneal:-" +
                    "\nAvene Diacneal treatment is an ideal alternative to Retino-A. The product is an effective one for healing the prevailing pimples, and preventing further breakouts. Fortunately, this is not a prescription drug." +
                    "\n2)Neutrogena- Deep Clean, Benzol Peroxide Acne Creams." +
                    "\n3)Glyco-6 Glycolic Acid Cream for Acne." +
                    "\n4)Clearasil Ultra Rapid Action Pimple Clearing Cream.");
        }
        else if("allergy".equals(bucket)){
            tv.setText("1)Diphenhydramine (Benadryl):-" +
                    "\nadults and children 12 years of age and over 25 mg to 50 mg (1 to 2 capsules)." +
                    "\n2)Chlorpheniramine:-" +
                    "Tablets or syrup: 4 mg orally every 4 to 6 hours.Sustained-release: 8 to 16 mg orally every 8 to 12 hours as needed or 16 mg orally once a day as needed.Maximum dose 32 mg/day.");
        }
        else if("asthama".equals(bucket)){
            tv.setText("1)Albuterol (Salbutamol):-" +
                    "\nPO- The usual starting dose is 1.25 mg or 0.63 mg, 3 or 4 times daily." +
                    "\n2)Amoxicillin and Bromhexine:-" +
                    "\nAdult: PO- Each capsule contains amoxicillin 250 mg and bromhexine 8 mg: 1-2 capsule 8 hourly, up to 48 hours.Liquid 5 ml contains amoxicillin 125 mg and bromhexine 4 mg. Over 5 years: 10ml 8 hourly. Under 5 years: 2.5-5ml 8 hourly. Duration as for adults. " +
                    "\n3)Bambuterol:-" +
                    "\nPO: Initially 10 mg at bedtime, increased if necessary to 20 mg once daily.");
        }
        else if("anemia".equals(bucket)){
            tv.setText("1)Carbonyl Iron:-" +
                    "\nAdult: 50 mg orally three times a day.Child: 2 to 4 mg/kg/day divided every 12 to 24 hours (maximum daily dose = 15 mg).Infants: 1 to 2 mg/kg/day (maximum 15 mg) in 1 to 2 divided doses." +
                    "\n2)Cyanocobalamin (Vitamin B12):-" +
                    "\nAdult: IM- 250-1,000 mcg on alternate days for 1-2 week, then 250 mcg weekly. Maintenance: 1,000-mcg monthly." +
                    "\n3)Darbepoetin alfa:-" +
                    "\nSC/IV- The initial dose is 0.45 mcg/kg body weight, as a single injection once weekly. \nFor patients not receiving dialysis: The initial dose is 0.75 mcg/kg as a single injection once every 2 weeks.");
        }
        else if("bronchitis".equals(bucket)){
            tv.setText("1)Amoxicillin:-" +
                    "\nAdult- PO- The recommended dose range is 0.25 to 3gm.Child- The recommended dose is 25 mg/kg/day in divided doses every 12 hours." +
                    "\n2)Ampicillin:-" +
                    "\nAdult- PO/IM/IV- The recommended dose range is 0.5 to 3gm every 6 hours or 4 times/day. Child- 25 to 50mg/kg/day." +
                    "\n3)Azithromycin:-" +
                    "\nAdult: PO- Respiratory tract, Skin and soft tissue infections- 500 mg once daily for 3 days. Or 500mg on day 1 followed by 250mg on days 2 to 5.");
        }

        else if("cholera".equals(bucket)){
            tv.setText("1)Chloramphenicol:-" +
                    "\nAdult: PO- The recommended dose is 50 mg/kg/day in 4 divided doses, may increase to 100 mg/kg/day in more severe infections.Eye Drops: As 0.5% solution: Instill 1 or 2 drops 2 hourly." +
                    "\n2)Cholera Vaccine:-" +
                    "\nCholera Vaccine is an immunization vaccine, prescribed for cholera." +
                    "\n3)Co-trimoxazole:-" +
                    "\nAdult- PO- The recommended dose is 2 tablets every 12 hours for a period of 10 to 14 days. Child- The recommended dose is 8 mg/kg of trimethoprim and 40 mg/kg of sulfamethoxazole daily in 2 divided doses every 12 hours.");
        }
        else if("dengue".equals(bucket)){
            tv.setText("1)Chloramphenicol:-" +
                    "\nAdult: PO- The recommended dose is 50 mg/kg/day in 4 divided doses, may increase to 100 mg/kg/day in more severe infections." +
                    "\n2)Ciprofloxacin:-" +
                    "\nAdult- Oral- The recommended dose range is 250 to 750mg/day in divided doses." );
        }

        else if("diabetes".equals(bucket)){
            tv.setText("1)Atorvastatin:-" +
                    "\nAdult PO- Initial- The recommended dose is 10 mg daily. Maximum: 80 mg/day." +
                    "\n2)Canagliflozin:-" +
                    "\nPO- The recommended initial dose is 100 mg once daily." +
                    "\n3)Chlorpropamide:-" +
                    "\nGet Prescription By Doctor");
        }

        else if("dehydration".equals(bucket)){
            tv.setText("The Patient Suffering with minor dehydration can take oral solutions...But in case of major dehydration person should contact the doctor immediately.");
        }

        else if("diarrhea".equals(bucket)){
            tv.setText("1)Anti-Diarrheal:-" +
                    "\n2 caplets after the first loose stool; 1 caplet after each subsequent loose stool; but no more than 4 caplets in 24 hours" +
                    "\n2)Take Oral Solution" +
                    "\n3)Major Diarrhea:-" +
                    "\nContact to doctor");
        }

        else if("ear blockage".equals(bucket)){
            tv.setText("1)Triethanolamine Polypeptide" +
                    "\nFill ear canal with this medication and allow it to remain for 15-30 minutes. Then gently flush with lukewarm water. ");
        }

        else if("eye allergy".equals(bucket)){
            tv.setText("1)Carbinoxamine:-" +
                    "\nTablets- Usual Adult Dosage: 1 or 2 tablets (4 to 8 mg) 3 to 4 times daily.\nUsual Child’s Dosage: Six to eleven years – 1/2 to 1 tablet (2 to 4 mg) 3 to 4 times daily.\nOral Solution - Usual Adult Dosage: 1 or 2 teaspoonfuls (4 to 8 mg) 3 to 4 times daily.\nUsual Child's Dosage (approximately 0.2 to 0.4 mg/kg/day, divided into 3 to 4 doses) Six to eleven years - ½ to 1 teaspoonful (2 to 4 mg) 3 to 4 times daily." +
                    "\n2)Dexamethasone Ophthalmic- Otic:-" +
                    "\nOphthalmic- As 0.1% solution: Instill 1-2 drops 4-6 times/day. As 0.05% ointment: Apply 0.5-1mg 4 times/day.");
        }

        else if("yellow fever".equals(bucket)){
            tv.setText("1)Yellow Fever Vaccine" +
                    "\nSubcutaneous - Primary Vaccination: The recommended dose is 0.5 ml." +
                    "\nBooster Doses: Re-immunization with 17D vaccine is recommended every 10 years.");
        }

        else if("vomiting".equals(bucket)){
            tv.setText("1)Meclizine hydrochloride (Bonine)" +
                    "\n2)Dimenhydrinate (Dramamine)" +
                    "\n3)Emetrol" +
                    "\n4)Bismuth subsalicylate (Pepto-Bismol)");
        }

        else if("fits".equals(bucket)){
            tv.setText("1)Carbamazepine:-" +
                    "\nAdult: PO Epilepsy Initial: 100-200 mg 1-2 times/day" +
                    "\n2)Clobazam:-" +
                    "\nAdult: PO- Adjunct in epilepsy; Anxiety- The recommended dose is 20-30 mg/day, up to 60 mg/day for severe conditions." +
                    "\n3)Clonazepam:-" +
                    "\nAdults: The initial dose should not exceed 1.5 mg/day divided into three doses.");
        }

        else if("food allergy".equals(bucket)){
            tv.setText("1)Liraglutide [rDNA] Injection:-" +
                    "\nSC- The recommended initial dose is 0.6 mg per day for one week.");
        }

        else if("fracture".equals(bucket)){
            tv.setText("1)Aspirin and Oxycodone:-" +
                    "\nThe usual dosage is one tablet every 6 hours as needed for pain. The maximum daily dose of aspirin should not exceed 4 grams or 12 tablets.");
        }

        else if("bleeding gums".equals(bucket)){
            tv.setText("1)Chlorhexidine:-" +
                    "\nAs 0.2% solution: Rinse with 10 ml for 1 min 2-3 times/day." +
                    "\n2)Multivitamin:-" +
                    "\nDose is based on patient’s condition.");
        }

        else if("hair fall".equals(bucket)){
            tv.setText("1)Cetrimide:-" +
                    "\nWound cleansing - Topical : Adult: Apply 0.1-1% aqueous solution or 0.5% cream onto affected area.\nSeborrhoeic dermatitis - Topical : Adult: Apply 10% shampoo solution onto the scalp." +
                    "\n2)Minoxidil oral:-" +
                    "\nAdult- The recommended initial dose is 5 mg/day as a single dose. Maximum: 100mg/day.\nChild- The initial dosage is 0.2 mg/kg/day as a single dose." +
                    "\n3)Spironolactone:-" +
                    "\nAdult- PO- The recommended dose range is 50 to 400mg/day for 3 to 4 weeks.");
        }

        else if("piles".equals(bucket)){
            tv.setText("1)Benzocaine:-" +
                    "\nAdult: Topical analgesia and anesthesia- As gel, paste, cream, lotion, spray, solution or suppository up to 20%: Apply as directed by your physician." +
                    "\n2)Hydrocortisone:-" +
                    "\nIV- The recommended dose is 20mg per day." +
                    "\n3)Hydrocortisone Valerate:-" +
                    "\nTopical- Apply 2-3 times daily. Discontinue gradually.");
        }

        else if("height".equals(bucket)){
            tv.setText("1)Sermoline Acetate:-" +
                    "\nThe recommended dose is 0.2 - 0.3 mcg once daily at bedtime by subcutaneous injection." +
                    "\n2)Somatrem:-" +
                    "\nIM/IV- A weekly dosage of 0.30 mg/kg (approximately 0.90 IU/kg) of body weight.");
        }

        else if("heat stroke".equals(bucket)){
            tv.setText("1)Calcium Carbonate:-" +
                    "\nOral- 1 to 3 chewable tablets containing 500 mg calcium carbonate per day, or as directed by your physician. Maximum dose is 16 tablets/day. For pregnant woman maximum dose is 7 tabs/day." +
                    "\n2)Clobazam:-" +
                    "\nAdult: PO- Adjunct in epilepsy; Anxiety- The recommended dose is 20-30 mg/day, up to 60 mg/day for severe conditions.");
        }

        else if("hepatitis A".equals(bucket)){
            tv.setText("1)Hepatitis A Vaccine:-" +
                    "\nIM- Single dose of 0.5 or 1 ml depending on the product and patient's age. Give booster dose 6-12 months after the initial dose. Give via subcutaneous administration in haemophiliacs.");
        }

        else if("hepatitis B".equals(bucket)){
            tv.setText("1)Adefovir Dipivoxil:-" +
                    "\nAdult- PO -The recommended dose is 10mg/day." +
                    "\n2)Hepatitis B (Recombinant) Vaccine" +
                    "\nGiven via subcutaneous administration(injected just under the skin) in haemophiliacs. Adults 20 yr of age and older- IM - The recommended dose is 20 mcg at 0, 1, and 6th month.\nInfants of HBsAg-Positive or -Negative Mothers Children and Adolescents 1 to 19 yr of age - IM- The recommended dose is 10 mcg at 0, 1, and 6th month.");
        }

        else if("hepatitis C".equals(bucket)){
            tv.setText("1)Boceprevir:-" +
                    "\nAdult- PO- The recommended dose is 800 mg (four 200-mg capsules) three times daily (every 7-9 hours)" +
                    "\n2)Interferon Alfa-2b and Ribavirin:-" +
                    "\nDose is based on patient’s condition and body weight.");
        }

        else if("blood pressure".equals(bucket)){
            tv.setText("1)Acebutolol:-" +
                    "\nPO- The recommended initial dose is 200-400mg, twice daily. The maximum allowed dose is 1200mg/day." +
                    "\n2)Acetazolamide:-" +
                    "\nThe dosage ranges from 250 mg to 1 g of acetazolamide for 24 hours, usually in divided doses for amounts over 250 mg.\nAdult- PO Diuresis 250-375 mg/day. Glaucoma; Epilepsy 250-1,000 mg/day. Prophylaxis of high altitude sickness 500-1,000 mg/day. IV Chronic open angle glaucoma 250-1000 mg 24 hrly and Epilepsy 8-30 mg/kg/day in divided doses." +
                    "\n3)Aliskiren:-" +
                    "\nPO- The usual recommended starting dose is 150 mg once daily. Maximum: 300mg.");
        }

        else if("heart attack".equals(bucket)){
            tv.setText("1)Alteplase:-" +
                    "\nAdult: Acute massive pulmonary embolism- Total dose: 100 mg (not >1.5 mg/kg for patients weighing <65 kg). 10 mg as bolus, followed by infusion of the remainder dose over 2 hour." +
                    "\n2)Aspirin:-" +
                    "\nAdult: PO- Prophylaxis of MI- 75-325 mg/day.\nStent implantation -325 mg 2 hr pre-op, then 160-325 mg/day");
        }

        else if("high cholesterol".equals(bucket)){
            tv.setText("1)Atorvastatin:-" +
                    "\nAdult PO- Initial- The recommended dose is 10 mg daily. Maximum: 80 mg/day." +
                    "\n2)Bezafibrate:-" +
                    "\nAdult: PO- 200 mg 3 times/day. Maintenance: 200 mg twice daily. Extended release 400 mg/day." +
                    "\n3)Cholestyramine Resin:-" +
                    "\nAdults - PO- Initial: 1 scoop or single-use packet (4 g anhydrous cholestyramine) daily to twice daily. Maintenance: 2 to 4 packets or scoops daily, divided into 2 doses.\nChildren - PO- usual dose is 240 mg/kg/day.");
        }

        else if("low blood pressure".equals(bucket)){
            tv.setText("1)Mephentermine:-" +
                    "\nAdult: IV- Maintenance of BP in hypotensive state- 30-45 mg as single dose." +
                    "\n2)Midodrine:-" +
                    "\n10 mg orally three times a day. Do not give more frequently than every 3 hours, after the evening meal, or less than 4 hours before bedtime.");
        }

        else if("hypersomnia".equals(bucket)){
            tv.setText("1)Caffeine:-" +
                    "\n100 to 200 mg orally not more often than every 3 to 4 hours." +
                    "\n2)Carbamazepine:-" +
                    "\nInitial dose: 200 mg orally twice a day (immediate and extended release) or 100 mg orally 4 times a day (suspension)." +
                    "\n3)Dextroamphetamine" +
                    "\nInitial Dose: 10 mg per day orally upon awakening.\nMaintenance Dose: The daily dosage may be increased in increments of 10 mg at weekly intervals, up to 60 mg per day in 2 to 3 divided doses.");
        }

        else if("back injuries".equals(bucket)){
            tv.setText("1)Acetaminophen and Hydrocodone Bitartrate:-" +
                    "\nPO 1 to 2 tablets or capsules (hydrocodone 2.5 to 10 mg; acetaminophen 500 to 1,000 mg) every 4 to 6 h or 5 to 10 mL (elixir, solution 15 mL) every 4 to 6 h as needed. Max, 6 doses/day ( Zamicet )" +
                    "\n2)Aspirin:-" +
                    "\n3 grams per day in divided doses (spondyloarthropathies may require up to 4 grams per day in divided doses).");
        }

        else if("itching".equals(bucket)){
            tv.setText("1)Alclometasone Dipropionate:-" +
                    "\nApply cream or ointment sparingly 2–3 times daily." +
                    "\n2)Ammonium Lactate:-" +
                    "\nAmmonium Lactate Cream, 12% is indicated for the treatment of ichthyosis vulgaris and xerosis." +
                    "\n3)Oral, Intramuscular or Intravenous: 15 to 240 mg/day.");
        }

        else if("jaundice".equals(bucket)){
            tv.setText("1)phenobarbital oral" +
                    "\n2)Luminal injection" +
                    "\n3)phenobarbital sodium injection" +
                    "\n4)phenobarbital in 0.9 % sodium chloride intravenous" +
                    "\nGET THE DOSE OF MEDICINES PRESCRIBED BY DOCTOR");
        }

        else if("kala-ajar".equals(bucket)){
            tv.setText("1)Allopurinol:-" +
                    "\nInitial: 100 mg orally once a day.\nMaintenance: 200 to 300 mg (mild gout) orally once a day or 400 to 600 mg/day (moderately severe tophaceous gout) in divided doses." +
                    "\n2)Amphotericin B:-" +
                    "\nGet prescription by doctor" +
                    "\n3)Miltefosine:-" +
                    "\nGet prescription by doctor");
        }

        else if("kidney stones".equals(bucket)){
            tv.setText("1)Allopurinol:-" +
                    "\nInitial: 100 mg orally once a day.\nMaintenance: 200 to 300 mg (mild gout) orally once a day or 400 to 600 mg/day (moderately severe tophaceous gout) in divided doses." +
                    "\n2)Potassium Citrate:-" +
                    "\nIf urinary citrate is less than 150 mg/day: 60 mEq/day (30 mEq two times/day , 20 mEq three times/day, or 15 mEq four times/day) orally with meals or within 30 minutes after meals or bedtime snack." +
                    "\n3)Tamsulosin:-" +
                    "\n0.4 mg orally once daily one-half hour following the same meal each day");
        }

        else if("malaria".equals(bucket)){
            tv.setText("1)Artemether:-" +
                    "\nLess than 35 kg: Usual pediatric dose\n35 kg or more: 4 tablets as single initial dose, followed by 4 tablets after 8 hours, and then 4 tablets twice a day (morning and evening) for the following 2 days (total course: 24 tablets)" +
                    "\n2)Artesunate:-" +
                    "\nGet Prescription by doctor" +
                    "\n3)Bulaquine:-" +
                    "\n25 mg and 15 mg, respectively");
        }

        else if("menstrual periods".equals(bucket)){
            tv.setText("1)Norethindrone Acetate and Ethinyl Estradiol:-" +
                    "\nShould not miss any dose \n Don't take high dose \n Get prescribed by doctor");
        }

        else if("mouth ulcers".equals(bucket)){
            tv.setText("1)Benzocaine:-" +
                    "\nApply four times a day on affected portion" +
                    "\n2)Becosule:-" +
                    "\nTwo capsule per day");
        }

        else if("neck pain".equals(bucket)){
            tv.setText("1)Incobotulinumtoxina:-" +
                    "\nTotal dose is 120 units.\nDon't take over dose." +
                    "2)Pregabalin:-" +
                    "\nInitial dose: 50 mg 3 times a day.\nThe maximum recommended dose is 100 mg 3 times a day in patients with a creatinine clearance of at least 60 mL/min.");
        }

        else if("nose bleed".equals(bucket)){
            tv.setText("1)Plicamycin:-" +
                    "\n Get prescribed by doctor");
        }

        else if("obesity".equals(bucket)){
            tv.setText("1)Atorvastatin" +
                    "\n2)Benzphetamine" +
                    "\n3)Bezafibrate" +
                    "\n4)Diethylpropion" +
                    "\n5)Ezetimibe" +
                    "\n6)Fenofibric Acid" +
                    "\n7)Fluvastatin" +
                    "\n Get This medicines prescribed by doctor");
        }

        else if("polio".equals(bucket)){
            tv.setText("1)Polio Vaccine:-" +
                    "\nShould be taken in early age" +
                    "\nIf this is not taken in early age then there is no precaution method ");
        }

        else if("tuberculosis".equals(bucket)){
            tv.setText("1)BCG live - Bacillus Calmette- Guerin" +
                    "\n2)Bedaquiline" +
                    "\n3)Capreomycin" +
                    "\n4)Cycloserine" +
                    "\n5)Dexamethasone Oral" +
                    "\nGet prescribed by doctor");
        }

        else if("rabies".equals(bucket)){
            tv.setText("1)Ivermectin:-" +
                    "\n0.15 mg/kg orally once every 12 months.\nPatients with heavy ocular infection may require retreatment every 6 months. Retreatment may be considered at intervals as short as 3 months." +
                    "\n2)Rabies Vaccine:-" +
                    "\nThe pre-exposure schedule for rabies vaccination is 3 doses, given at the following times: (1) Dose 1: As appropriate, (2) Dose 2: 7 days after Dose 1, and (3) Dose 3: 21 days or 28 days after Dose 1.");
        }

        else if("rock fever".equals(bucket)){
            tv.setText("1)Chloramphenicol:-" +
                    "\n50 mg/kg/day IV divided q6hr; in exceptional cases, patients with moderately resistant organisms or severe infections may require increased dosage up to 100 mg/kg/day; decrease these high doses as soon as possible" +
                    "\nGet prescribed by doctor");
        }

        else if("wrinkles".equals(bucket)){
            tv.setText("1)Azficel-T:-" +
                    "\nonly one dose a day" +
                    "\nGet prescribed by doctor");
        }

        else if("skin disease(dermatology)".equals(bucket)){
            tv.setText("1)Alclometasone:-" +
                    "\nAlclometasone is a topical corticosteroid, prescribed for corticosteroid-responsive dermatoses." +
                    "\n2)Alclometasone Dipropionate:-" +
                    "\nAlclometasone Dipropionate is a synthetic corticosteroid, prescribed for itching, redness and swelling of skin." +
                    "\n3)Amcinonide:-" +
                    "\nAllantoin is a topical agent, prescribed for psoriasis, and other skin diseases." +
                    "\nPLEASE CONTACT TO DOCTOR TO GET THE PRESCRIPTION");
        }

        else if("smoking and tobacco".equals(bucket)){
            tv.setText("1)Bupropion:-" +
                    "\nInitial Dose: 150 mg orally once a day.\nMaintenance: Based on clinical response, this dosage may be increased to 300 mg/day, given as 150 mg twice a day, no sooner than 3 days after beginning therapy.");
        }

        else if("cough".equals(bucket)){
            tv.setText("1)Benadryl:-" +
                    "\nParenteral: 10 to 50 mg IV or IM as needed. May increase dose to 100 mg if required. Maximum daily dose 400 mg.\nOral: 25 to 50 mg orally every 6 to 8 hours.");
        }
        else {
            tv.setText("");
            Toast lol = Toast.makeText(this,"Search By Other Name",Toast.LENGTH_SHORT);
            lol.show();
        }
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
        Intent i = new Intent(Fetch_Medicine.this,ListView2.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        super.onBackPressed();
    }
}
