package corp.mahisan.medicinastore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 13-02-2015.
 */
public class Disease_info extends ActionBarActivity implements View.OnClickListener {
    AutoCompleteTextView act;
    ArrayAdapter<String> adapter;
    Button bt;
    Toolbar toolbar;
    TextView tv;
    Animation animFadein;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disease_info);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Disease Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        act = (AutoCompleteTextView) findViewById(R.id.act);
        bt = (Button) findViewById(R.id.button1);
        tv = (TextView) findViewById(R.id.tv1);
        tv.setMovementMethod(new ScrollingMovementMethod());
        String[] colors = getResources().getStringArray(R.array.diseaseList);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,colors);
        act.setAdapter(adapter);
        act.setThreshold(1);
        bt.setOnClickListener(this);
        animFadein = AnimationUtils.loadAnimation(this,
                R.anim.fade_in);
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
        Intent i = new Intent(Disease_info.this,ListView2.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        super.onBackPressed();
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        String bucket = act.getText().toString();
        tv.setScrollY(0);
        tv.startAnimation(animFadein);
        if("achondroplasia".equals(bucket)){
            tv.setText("Achondroplasia is a form of Dwarfism. It is part of the chondrodystrophies or osteochondrodysplasias family which makes bones in a human's skeleton be too short or grow too slowly. It often affects the femur and humerus. It is caused by a dominant allele. That means only one parent has to have the gene. This gives a child a 50% chance of getting the condition. If both parents have the gene the chances are increased to 75%, but in 25% of the cases, it is very unlikely that the child would live more than a few months. However, the condition can also occur without either parent having the gene. Achondroplasia is caused by a change in the DNA for fibroblast growth factor receptor 3. This change affects the making of cartilage. Now that the part of the DNA that causes the condition is known, there is hope that new treatments may be developed.");
           // iv.setImageResource(R.drawable.achondroplasia);
        }

        else if("acne".equals(bucket)){
            tv.setText("Acne is an infection of the skin, caused by changes in the sebaceous glands. The most common form of acne is called acne vulgaris, which means \"common acne\". The redness comes from the inflammation of the skin in response to the infection.\nOils from the glands combine with dead skin cells to block hair follicles. Under the blocked pore, oil builds up. Skin bacteria can then grow very quickly. This infection makes the skin become swollen and red, which becomes visible.\nThe face, chest, back, and upper arms are most common places for acne to happen.\nAcne is common during puberty, when a person is turning from a child into an adult, because of high levels of hormones. Acne becomes less common as people reach adulthood." +
                    "\n1)TREATMENTS:-" +
                    "\nMany things are sold to treat acne, the most popular being benzoyl peroxide. Many of these things have not been scientifically proven to help acne. However, a mix of commercial and homemade treatments can help with acne for various reasons.\nKilling the bacteria that grow in the blocked follicles. This can be done by ingesting antibiotic medication, or by putting antibiotics on the skin. Antibiotics act quickly and are a powerful way of temporarily getting rid of acne. When the body develops a resistance to the antibiotics, the bacteria returns stronger than before.\nRemoving oil on the skin can be done by taking drugs that contain Vitamin A. Accutane is the name of the most famous treatment using massive quantities of Vitamin A.\nRemoving dead skin cells can be done by treatment with salicylic acid. This encourages the skin to peel away the top layer of cells.\nPopping a pimple should not be done by anyone but a qualified dermatologist. Pimple popping irritates skin, can make the bacteria spread, and can cause scars. If you must pop a pimple yourself, it is advised to apply warm water to the area before popping it and to wash your hand thoroughly before beginning so as to avoid spreading bacteria via the hands. Applying hot water will open up the pores and reduce the damage because it will require less force to pop it.");
           // iv.setImageResource(R.drawable.acne);
        }

        else if("albinism".equals(bucket)){
            tv.setText("Albinism is a condition some people and animals are born with. This condition is caused by a lack of pigment (colour) in their hair, eyes, and skin. A person or animal with albinism is called an albino, but people may prefer to be called a \"person with albinism\".\nPeople with albinism usually have white or light blonde hair and very fair skin. Their eyes are blue, or rarely pink-ish. People with albinism do have some problems including bad vision and getting sunburn easily. All of these problems are because people with alibinism have little or no pigments in their eyes, skin and hair.[1]\nVision problems in albinism include nystagmus (irregular fast movements of the eyes), strabismus (where the eyes fail to balance) and refractory errors (like being near-sighted or far-sighted).\nAlbino animals are more easily seen and so may be attacked by predators. They lack the camouflage that the non-albino members of their species have. Also, where colour is a factor in mate selection, they may be at a disadvantage there, too.");
           // iv.setImageResource(R.drawable.albinism);
        }

        else if("alcoholic hepatitis".equals(bucket)){
            tv.setText("Alcoholic hepatitis is hepatitis (inflammation of the liver) due to excessive intake of alcohol. It is usually found in association with hepatosteatosis, an early stage of alcoholic liver disease, and may contribute to the progression of fibrosis, leading to cirrhosis . Symptoms are jaundice, ascites (fluid accumulation in the abdominal cavity), fatigue and hepatic encephalopathy (brain dysfunction due to liver failure). Mild cases are self-limiting, but severe cases have a high risk of death. Severe cases may be treated with glucocorticoids." +
                    "\nSYMPTOMS AND SIGNS" +
                    "\nAlcoholic hepatitis is characterized by a variable constellation of symptoms, which may include feeling unwell, enlargement of the liver, development of fluid in the abdomen (ascites), and modest elevation of liver enzyme levels (as determined by liver function tests). Alcoholic hepatitis can vary from mild with only liver enzyme elevation to severe liver inflammation with development of jaundice, prolonged prothrombin time, and even liver failure. Severe cases are characterized by either obtundation (dulled consciousness) or the combination of elevated bilirubin levels and prolonged prothrombin time; the mortality rate in both severe categories is 50% within 30 days of onset.\nAlcoholic hepatitis is distinct from cirrhosis caused by long-term alcohol consumption. Alcoholic hepatitis can occur in patients with chronic alcoholic liver disease and alcoholic cirrhosis. Alcoholic hepatitis by itself does not lead to cirrhosis, but cirrhosis is more common in patients with long term alcohol consumption. Some alcoholics develop acute hepatitis as an inflammatory reaction to the cells affected by fatty change. This is not directly related to the dose of alcohol. Some people seem more prone to this reaction than others. This is called alcoholic steatonecrosis and the inflammation probably predisposes to liver fibrosis.");

            //iv.setImageResource(R.drawable.alcoholic_hepatitis);
        }

        else if("allergy".equals(bucket)){
            tv.setText("An allergy is something which triggers an allergic reaction. This is the immune system defending the body against attack by bacteria and viruses.\nSometimes the systems goes wrong, and is triggered by some quite normal food, or flares up when the family pet comes into the room. That is what the ordinary person calls an 'allergy'.\nAllergic reactions to plant pollen is very common, and is controlled by antihistamine tablets. A bit more serious is allergy to bee stings." +
                    "\nSYMPTOMS AND SIGNS" +
                    "\nMany allergens such as dust or pollen are airborne particles. In these cases, symptoms arise in areas in contact with air, such as eyes, nose, and lungs. For instance, allergic rhinitis, also known as hay fever, causes irritation of the nose, sneezing, itching, and redness of the eyes.[5] Inhaled allergens can also lead to asthmatic symptoms, caused by narrowing of the airways (bronchoconstriction) and increased production of mucus in the lungs, shortness of breath (dyspnea), coughing and wheezing.");
            //iv.setImageResource(R.drawable.allergy);
        }

        else if("alopecia".equals(bucket)){
            tv.setText("Baldness (also known as Alopecia) is when someone has no hair on his or her head. Sometimes this is inherited from parents or grandparents, or it can be done on purpose if somebody cuts off all their hair off. Some monks or South Korean soldiers in the army do this.\nBaldness is most often caused by a medical condition known as Androgenic alopecia. This is found in humans, as well as in some animals. When it occurs, it will mean that those affected will permanently lose some (or all) of their hair. Since some of the factors are linked to the genes on the chromosome, the condition can be seen more often with men, than with women.");
            //iv.setImageResource(R.drawable.alopecia);
        }

        else if("alzheimer's".equals(bucket)){
            tv.setText("Alzheimer's Disease (AD) is a brain disease that slowly destroys brain cells. As of 2014, there is no cure for Alzheimer's disease. With time, the different symptoms of the disease become more marked. Many people die because of Alzheimer's disease. The disease affects different parts of the brain but has its worst effects on the areas of the brain that control memory, language, and thinking skills. Alzheimer's Disease is the most common form of senile dementia accounting for up to 70% of cases.\nThe clinical symptoms of AD usually occurs after age 65, but changes in the brain which do not cause symptoms and are caused by Alzheimer's, may begin years or in some cases decades before. Although the symptoms of AD begin in older people it is not a normal part of aging.\nAt this time there is no cure for Alzheimer's, but there are treatments that can help some patients with the signs and symptoms so they do not affect them as badly. There are also treatments which slow down the disease so the damage to the brain does not happen as quickly. There are also certain personal habits that people can learn which may help to delay the onset of the disease.\nWhile it is not yet known exactly what causes Alzheimer's disease, there are a number of risk factors which may make a person more likely to get it. Some of these risk factors are genetic; changes to four different genes have been found which increase the risk.\nThe current lifetime risk for a 65-year-old person to get Alzheimer's disease is estimated to be at 10.5%. It is the sixth leading cause of death in the United States causing about 83,500 deaths a year. In 2007, there were more than 26.6 million people throughout the world who were affected by AD.[1]");
            //iv.setImageResource(R.drawable.alzheimer);
        }

        else if("amblyopia".equals(bucket)){
            tv.setText("Amblyopia, more commonly called lazy eye, is a condition that affects the eye. In this condition, a nerve pathway leading from one eye to the brain does not develop correctly, leading to poor vision. As a result, blurred images are sent to the brain.");
            //iv.setImageResource(R.drawable.amblyopia);
        }

        else if("amebiasis".equals(bucket)){
            tv.setText("Amebiasis is an intestinal infection. It is normally spread when someone eats or drinks something that has with a microscopic parasite called Entamoeba histolytica (E. histolytica). The parasite is an amoeba, a single-celled organism. This is how illness got its name.\nIn many cases, the parasite lives in a person's large intestine and does not cause any symptoms. It can enter the lining of the large intestine and cause bloody diarrhea, stomach pains, cramping, nausea, loss of appetite, or fever. In rare cases, it can spread into other organs such as the liver, lungs, and brain.");
            //iv.setImageResource(R.drawable.amebiasis);
        }

        else if("anemia".equals(bucket)){
            tv.setText("Anemia (U.S. spelling) or anaemia means not having enough red blood cells or hemoglobin in the blood." +
                    "\nSYMPTOMS AND SIGNS" +
                    "\nAnemia goes undetected in many people, and symptoms can be minor or vague. The signs and symptoms can be related to the underlying cause or the anemia itself. Most commonly, people with anemia report feelings of weakness, or fatigue, general malaise, and sometimes poor concentration. They may also report dyspnea (shortness of breath) on exertion. In very severe anemia, the body may compensate for the lack of oxygen-carrying capability of the blood by increasing cardiac output. The patient may have symptoms related to this, such as palpitations, angina (if pre-existing heart disease is present), intermittent claudication of the legs, and symptoms of heart failure. On examination, the signs exhibited may include pallor (pale skin, lining mucosa, conjunctiva and nail beds), but this is not a reliable sign. There may be signs of specific causes of anemia, e.g., koilonychia (in iron deficiency), jaundice (when anemia results from abnormal break down of red blood cells — in hemolytic anemia), bone deformities (found in thalassemia major) or leg ulcers (seen in sickle-cell disease). In severe anemia, there may be signs of a hyperdynamic circulation: tachycardia (a fast heart rate), bounding pulse, flow murmurs, and cardiac ventricular hypertrophy (enlargement). There may be signs of heart failure. Pica, the consumption of non-food items such as ice, but also paper, wax, or grass, and even hair or dirt, may be a symptom of iron deficiency, although it occurs often in those who have normal levels of hemoglobin. Chronic anemia may result in behavioral disturbances in children as a direct result of impaired neurological development in infants, and reduced scholastic performance in children of school age. Restless legs syndrome is more common in those with iron-deficiency anemia");
            //iv.setImageResource(R.drawable.anemia);
        }

        else if("anorexia".equals(bucket)){
            tv.setText("Anorexia nervosa (usually just called anorexia) is an eating disorder. People with anorexia think that they are fat, or desperately fear becoming fat even if they are very skinny. To try to lose weight, anorexics do not eat enough. When they do eat, they do not eat the amount of food their body needs, in an effort to avoid gaining weight. This causes them to lose too much weight too quickly. This is very harmful to a person's body. There are various treatments for anorexia. One example is the Maudsley Method. This type of treatment is for patients who are 18 or younger. Two thirds of adolescent anorexia patients are 'recovered' at the end of this treatment. People with anorexia are more likely to die than people with any other mental illness." +
                    "\n SYMPTOMS" +
                    "\nRapid, unexplained weight loss\nRefusal to maintain a healthy weight\nLow self-esteem and distorted self-image\nFrequent weighing, \"body-checking\", or negative comments on appearance\nAmenorrhoea, the loss of menstrual periods\nLow body temperature\nLow pulse, blood sugar and blood pressure\nDepression");
            //iv.setImageResource(R.drawable.anorexia);
        }

        else if("anosmia".equals(bucket)){
            tv.setText("Anosmia is the loss of the olfaction (the sense of smell). The term is also used for people who never had this sense. The loss can be temporary, or permanent. The conditions that cause a temporary loss of this sense include:\nUpper respiratory tract infection, for example a common cold\nObstructing the nasal cavity, eg. through seasonal allergies, or a nasal polyp.\nSide-effects of certain drugs or of certain poisons.\nConcussion, brain tumors.\nOlfaction depends on two nerves (Nervus olfactorius and Nervus trigeminus), as well as the part of the brain which processes the information. Damage to this system will have an effect on olfaction; permanent damage may lead to a permanent loss of olfaction.");
            //iv.setImageResource(R.drawable.anosmia);
        }

        else if("anotia".equals(bucket)){
            tv.setText("Anotia (\"no ear\") describes a rare, congenital deformity, that involves the complete absence of the pinna, the outer projected portion of the ear, and narrowing or absence of the ear canal. This contrasts with microtia, in which a small part of the pinna is present. Anotia and microtia may occur unilaterally (only one ear affected) or bilaterally (both ears affected). This deformity results in conductive hearing loss, deafness.");
            //iv.setImageResource(R.drawable.anotia);
        }

        else if("anthrax".equals(bucket)){
            tv.setText("Anthrax, or splenic fever is a disease. Both humans and other animals can get it. It is caused by the bacterium bacillus anthracis. It is common with even-toed ungulates (some hoofed creatures, like camels and giraffes). The spores of the bacteria can live for hundreds of years. Humans usually catch the disease from animals. It is usually not passed from one human to another. Anthrax can be treated with antibiotics. There is also a vaccine against it. If not treated, anthrax often leads to death.");
            //iv.setImageResource(R.drawable.anthrax);
        }

        else if("appendicitis".equals(bucket)){
            tv.setText("Appendicitis is a medical condition. It is when the vermiform appendix gets inflamed. The infection can be very dangerous. Usually, the inflamed appendix is removed. If it is not treated, many people die from it, mainly because of peritonitis and shock.[1] Reginald Fitz first described acute appendicitis in 1886.[2] It is one of the leading causes worldwide of pain in the belly.");
            //iv.setImageResource(R.drawable.appendicitis);
        }

        else if("apraxia".equals(bucket)){
            tv.setText("Apraxia (from Greek praxis, an act, work, or deed[1]) is the inability to execute learned purposeful movements,[2] despite having the desire and the physical capacity to perform the movements. Apraxia is an acquired disorder of motor planning, but is not caused by incoordination, sensory loss, or failure to comprehend simple commands (which can be tested by asking the person to recognize the correct movement from a series). It is caused by damage to specific areas of the cerebrum. Apraxia should not be confused with ataxia, a lack of coordination of movements; aphasia, an inability to produce and/or comprehend language; abulia, the lack of desire to carry out an action; or allochiria, in which patients perceive stimuli to one side of the body as occurring on the other. Developmental coordination disorder (DCD) is the developmental disorder of motor planning.");
            //iv.setImageResource(R.drawable.apraxia);
        }

        else if("argyria".equals(bucket)){
            tv.setText("Argyria is a medical condition caused by the exposure to silver. People with this condition may have a change in skin color to pale or \"greyish\".");
            //iv.setImageResource(R.drawable.argyria);
        }

        else if("arthritis".equals(bucket)){
            tv.setText("Arthritis (from Greek arthro-, joint + -itis, inflammation; plural: arthritides) is a form of joint disorder that involves inflammation of one or more joints.[1][2] There are over 100 different forms of arthritis.[3][4] The most common form, osteoarthritis (degenerative joint disease), is a result of trauma to the joint, infection of the joint, or age. Other arthritis forms are rheumatoid arthritis, psoriatic arthritis, and related autoimmune diseases. Septic arthritis is caused by joint infection.\nThe major complaint by individuals who have arthritis is joint pain. Pain is often a constant and may be localized to the joint affected. The pain from arthritis is due to inflammation that occurs around the joint, damage to the joint from disease, daily wear and tear of joint, muscle strains caused by forceful movements against stiff painful joints and fatigue.");
            //iv.setImageResource(R.drawable.arthritis);
        }

        else if("aseptic meningitis".equals(bucket)){
            tv.setText("Meningitis happens when the brain's lining becomes inflamed. This lining is called the meninges. Aseptic meningitis occurs when there are signs of meningitis. However, when a sample of brain fluid is taken, bacteria do not grow. This condition is often treatable. In many cases, recovery takes 7-10 days.");
            //iv.setImageResource(R.drawable.aseptic_meningitis);
        }

        else if("asthenia".equals(bucket)){
            tv.setText("Weakness or asthenia is a symptom of a number of different conditions.[1] The causes are many and can be divided into conditions that have true or perceived muscle weakness. True muscle weakness is a primary symptom of a variety of skeletal muscle diseases, including muscular dystrophy and inflammatory myopathy. It occurs in neuromuscular junction disorders, such as myasthenia gravis.");
            //iv.setImageResource(R.drawable.asthenia);
        }

        else if("asthma".equals(bucket)){
            tv.setText("Asthma (or Asthma bronchiale) is a disease that hurts the airways inside the lungs. It causes the tissue inside the airways to swell. Asthma also causes the bands of muscle around the airways to become narrow. This makes it hard for enough air to pass through and for the person to breathe normally. Asthma also causes mucous-making cells inside the airways to make more mucous than normal. This blocks the airways, which are already very narrow during an asthma attack and makes it even more difficult to breathe.\nA person having an asthma attack often makes wheezing sounds when trying to breath, this is the sound of air trying to pass through the very narrow airway. They also have shortness of breath, which means they cannot take a full deep breath. Chest tightness may happen which feels like their chest is being squeezed. They may also cough a lot.");
            //iv.setImageResource(R.drawable.asthma);
        }

        else if("atherosclerosis".equals(bucket)){
            tv.setText("Arteriosclerosis is a general term for a hardening of the walls of a person's larger arteries. There are various types; arteriolosclerosis, medial calcific sclerosis and arteriosclerosis obliterans. It is often seen in people with high blood pressure.");
            //iv.setImageResource(R.drawable.atherosclerosis);
        }

        else if("athetosis".equals(bucket)){
            tv.setText("Athetosis is a symptom characterized by slow, involuntary, convoluted, writhing movements of the fingers, hands, toes, and feet and in some cases, arms, legs, neck and tongue.[1] Movements typical of athetosis are sometimes called athetoid movements. Lesions to the brain are most often the direct cause of the symptoms, particularly to the corpus striatum.[2] This symptom does not occur alone and is often accompanied by the symptoms of cerebral palsy, as it is often a result of this disease. Treatments for athetosis are not very effective, and in most cases are simply aimed at the uncontrollable movement, rather than the cause itself.");
            //iv.setImageResource(R.drawable.athetosis);
        }

        else if("atrophy".equals(bucket)){
            tv.setText("Atrophy is the partial or complete wasting away of a part of the body. Causes of atrophy include mutations (which can destroy the gene to build up the organ), poor nourishment, poor circulation, loss of hormonal support, loss of nerve supply to the target organ, excessive amount of apoptosis of cells, and disuse or lack of exercise or disease intrinsic to the tissue itself. Hormonal and nerve inputs that maintain an organ or body part are referred to as trophic [noun] in medical practice (\"trophic\" is an adjective that can be paired with various nouns). Trophic describes the trophic condition of tissue. A diminished muscular trophic is designated as atrophy.\nAtrophy is the general physiological process of reabsorption and breakdown of tissues, involving apoptosis. When it occurs as a result of disease or loss of trophic support due to other disease, it is termed pathological atrophy, although it can be a part of normal body development and homeostasis as well.");
            //iv.setImageResource(R.drawable.atrophy);
        }

        else if("bacterial meningitis".equals(bucket)){
            tv.setText("Bacterial meningitis is meningitis caused by bacteria. It is almost always fatal without antibiotics." +
                    "\nSYMPTOMS:-" +
                    "\nHigh fever\nSeizures\nAltered mental status (including changes in attention)\nStiff neck\nHeadache\nEmesis\nBulging fontnalles");
            //iv.setImageResource(R.drawable.bacterial_meningitis);
        }

        else if("beriberi".equals(bucket)){
            tv.setText("Beriberi is a disease of the nervous system caused by a person not getting enough thiamine (vitamin B1) in the diet. Thiamine is needed to break down food such as glucose. It is also found on the membranes of neurons. Symptoms of beriberi include severe lethargy and tiredness. There are also problems that affect the cardiovascular system, the nervous system, muscles, and gastrointestinal systems. It is often found in people with a history of drinking too much alcohol.[1] There are two kinds of beriberi, wet and dry. Wet beriberi mainly affects the cardiovascular system. Dry beriberi affects the nervous system. There is also a rare type of genetic beriberi.");
            //iv.setImageResource(R.drawable.beriberi);
        }

        else if("black death".equals(bucket)){
            tv.setText("The Black Death was a pandemic (an epidemic spreading over a large area) that killed millions of people. It started in Europe in 1347, and lasted until 1351. Almost one out of every three people in Europe got the disease and died. This means about 25 million people died from it in Europe alone.");
            //iv.setImageResource(R.drawable.black_death);
        }

        else if("botulism".equals(bucket)){
            tv.setText("Botulism is a rare disease caused by a bacteria called Clostridium botulinum. You can get it from eating meat that is not cooked properly. Babies can get it as well as adults. Symptoms include fever, vomiting, difficulty talking and stiffness of the facial muscles. Botulism toxin is a major ingredient in botox, a gel that stiffens the facial muscles to make people look younger.\nBotulism is caused by a species of Clostridium, C. botulinum which is transmitted through food containing endospores or through a wound. The most postent neurotoxin known is produced when the bacteria contain a temperature bacteriophage which codes for the toxin. Foods which have been improperly canned are responsible for 90% of the cases of botulism. Natural, unpasteurized honey has been known to transmit infection and intoxication with the pathogen and the neurotoxin. Botulism is a neuroparalytic disease causing a flaccid paralysis; the neurotoxin blocks neurotransmitter uptake leading to an inability to contract muscles. The neurotoxin has been used medically in the management of severe pain by anaesthetists and also cosmetically to reduce wrinkles.");
            //iv.setImageResource(R.drawable.botulism);
        }

        else if("breast cancer".equals(bucket)){
            tv.setText("Breast cancer is cancer in the breast.\nIn the world, breast cancer is the fifth most common cause of cancer death. The first four are lung cancer, stomach cancer, liver cancer, and colon cancer. In 2005, breast cancer caused 502,000 deaths (7% of cancer deaths; almost 1% of all deaths) in the world.[1] Among all women in the world, breast cancer is the most common cancer.\nIn the United States, breast cancer is the most common cancer in women, and the second most common cause of cancer death in women (after lung cancer). In 2007, breast cancer caused about 40,910 deaths (7% of cancer deaths; almost 2% of all deaths) in the U.S. Women in the United States have a 1 in 8 chance of getting breast cancer in their lives. They have a 1 in 33 chance of death from breast cancer.[3]\nThere are many more people getting breast cancer since the 1970s. This is because of how people in the Western world live.[4][5] Because the breast is composed of identical tissues in males and females, breast cancer also occurs in males, though it is less common.[6]\nWhen a person gets breast cancer, they can try to cure it in three ways. Doctors can cut out the cancer (mastectomy or lumpectomy). They can give the person drugs (chemotherapy). They can also try to kill the cancer with energy (radiation). If one cure does not work, they may need to try another.");
            //iv.setImageResource(R.drawable.breast_cancer);
        }

        else if("bronchitis".equals(bucket)){
            tv.setText("Bronchitis is inflammation of the bronchi caused by irritation. It may also refer to acute bronchitis or chronic bronchitis. It can be caused by infection or other causes such as smoking, or being exposed to cigarettes.");
            //iv.setImageResource(R.drawable.bronchitis);
        }

        else if("brucellosis".equals(bucket)){
            tv.setText("Brucellosis is a disease that is caused by bacteria in the Brucella genus. It is also called Bang's disease, Crimean fever, Gibraltar fever, Malta fever, Maltese fever, Mediterranean fever, rock fever, and undulant fever.[1][2] It is a very contagious disease (can be spread very easily from one person to another.)\nBrucellosis is a zoonosis, a disease that is spread from animals to humans. Humans get the disease by drinking milk that is unsterilized, or by eating meat from sick animals. Sometimes, but not very often, the disease can be spread from human to human.[3]\nThe disease was first called \"Malta fever.\" British doctors in the military first discovered it in Malta during the Crimean War (1850s). Dr. David Bruce was the first person to discover the bacteria that caused brucellosis.");
            //iv.setImageResource(R.drawable.brucellosis);
        }

        else if("bubonic plague".equals(bucket)){
            tv.setText("Bubonic plague is the best-known form of the disease plague, which is caused by the bacterium Yersinia pestis. The name bubonic plague is specific for this form of the disease, which enters through the skin, and travels through the lymphatic system.\nIfthe disease is left untreated, it kills about half its victims, in between three and seven days. The bubonic plague was the disease that caused the Black Death, which killed tens of millions of people in Europe, in the Middle Ages.[1]\nSymptoms of this disease include coughing, fever, and black spots on the skin.");
            //iv.setImageResource(R.drawable.bubonic_plague);
        }

        else if("bunion".equals(bucket)){
            tv.setText("A Hallux valgus, also called bunion, is when the bone or tissue around the joint at the base of the big toe becomes larger. The big toe (hallux) may turn in toward the second toe, and the tissues around it can become swollen and red.");
            //iv.setImageResource(R.drawable.bunion);
        }

        else if("cancer".equals(bucket)){
            tv.setText("Cancer is a type of disease or disorder related to malignant tumours (that is: body cells gone haywire and forming growths which are harmful for the body itself). When a person has cancer, their body has no control over cells which begin to split apart. In a person without cancer, healthy cells split apart all the time and copy themselves to create new healthy cells. In a person with cancer, this normal process of cells splitting and re-creating themselves actually helps spread cancer. Cancerous cells (cells that have cancer in them) split themselves, copy themselves, and make new cells that are copies of themselves - meaning that the new cells that were created are also cancerous.\nThese cells are able to go into other tissues by growing into them. They can also get into other tissues by putting themselves into faraway places in the body by metastasis. Metastasis is a process in which cancer cells move through the bloodstream or lymphatic system. When this happens, a person's cancer can be spread throughout his body (this is called \"metastasizing\" - the cancer has spread through metastasis).\nCancer can affect anybody at any age. Most types of cancer are more likely to affect people as they get older. This is because as a person's DNA gets older, their DNA may become damaged, or damage that happened in the past may get worse. One type of cancer that is more common in young men, rather than older people, is testicular cancer (cancer of the testicles).\nCancer is one of the biggest and most researched causes of death in developed countries.");
            //iv.setImageResource(R.drawable.cancer);
        }

        else if("carbon monoxide poisoning".equals(bucket)){
            tv.setText("Carbon monoxide poisoning occurs after enough inhalation of carbon monoxide (CO). Carbon monoxide is a toxic gas, but, being colorless, odorless, tasteless, and initially non-irritating, it is very difficult for people to detect. Carbon monoxide is a product of incomplete combustion of organic matter due to insufficient oxygen supply to enable complete oxidation to carbon dioxide (CO2). It is often produced in domestic or industrial settings by motor vehicles that run on gasoline, diesel, propane, methane, or other carbon-based fuels and tools, heaters, and cooking equipment that are powered by carbon-based fuels. Exposures at 100 ppm or greater can be dangerous to human health.\nSymptoms of mild acute poisoning will include light-headedness, confusion, headaches, vertigo, and flu-like effects; larger exposures can lead to significant toxicity of the central nervous system and heart, and even death. Following acute poisoning, long-term sequelae often occur. Carbon monoxide can also have severe effects on the fetus of a pregnant woman. Chronic exposure to low levels of carbon monoxide can lead to depression, confusion, and memory loss. Carbon monoxide mainly causes adverse effects in humans by combining with hemoglobin to form carboxyhemoglobin (HbCO) in the blood. This prevents hemoglobin from releasing oxygen in tissues, effectively reducing the oxygen-carrying capacity of the blood, leading to hypoxia. Additionally, myoglobin and mitochondrial cytochrome oxidase are thought to be adversely affected. Carboxyhemoglobin can revert to hemoglobin, but the recovery takes time because the HbCO complex is fairly stable.");
            //iv.setImageResource(R.drawable.carbon_monoxide_poisoning);
        }

        else if("cherubism".equals(bucket)){
            tv.setText("Cherubism is a rare genetic disorder that causes prominence in the lower portion in the face. The name is derived from the temporary chubby-cheeked resemblance to putti, often confused with cherubs, in Renaissance paintings.");
            //iv.setImageResource(R.drawable.cherubism);
        }

        else if("chicken pox".equals(bucket)){
            tv.setText("Chickenpox (or chicken pox) is a disease. Usually it is children who get the disease, but adults can also get it. People who have it get blisters or spots, mostly on the body and in the face. Those blisters are filled with a liquid. At some point the blisters will drain, and the person will want to scratch them. Burst blisters usually become healthy without leaving scars, unless they become infected. The symptoms come in two or three waves, and usually include fever.\nGetting chickenpox during a pregnancy is dangerous, because it can hurt both the mother and the child.\nThe Varicella virus, which causes Chickenpox\nChickenpox is caused by a virus of the herpes family. People who had chickenpox in the past can also get a related disease called shingles later. Shingles is caused by the same virus but usually is in only one part of the body.\nThere is a vaccine against it. Usually the chickenpox vaccine is given to children, if they did not have the disease before the start of puberty, that is aged 9–13 years old.");
            //iv.setImageResource(R.drawable.chicken_pox);
        }

        else if("cholera".equals(bucket)){
            tv.setText("Cholera is an infectious disease. It is caused by a bacterium Vibrio cholerae. This bacteria usually lives in water. Vibrio cholera is more common where fresh water mixes with salt water, like where rivers enter the ocean. It is more common in water with lots of algae." +
                    "\nSYMPTOMS:-" +
                    "\nCholera is an acute intestinal illness. It causes stomach aches, very watery and continuous diarrhea and vomiting. The diarrhea and vomiting, in turn, can cause very bad dehydration, leading to death if untreated.");
            //iv.setImageResource(R.drawable.cholera);
        }

        else if("colitis".equals(bucket)){
            tv.setText("Colitis is an ongoing digestive disease. The main symptom of the disease is swelling of the colon. Other symptoms include: high amounts of pain, tenderness in the abdomen, depression, large amount of weight loss, fatigue, and other, more severe symptoms. Colitis is treated through the use of antibiotics if it is found early, or surgery if it is caught too late.");
            //iv.setImageResource(R.drawable.colitis);
        }

        else if("common cold".equals(bucket)){
            tv.setText("The common cold (also known as nasopharyngitis, rhinopharyngitis, acute coryza, or a cold) is an easily spread infectious disease of the upper respiratory system. It damages mostly the nose and throat. The symptoms include cough, painful throat, runny nose (rhinorrhea), and fever. These symptoms usually last seven to ten days, but sometimes up to three weeks. Over two hundred different viruses can cause the common cold, but rhinoviruses are the most common cause.\nAcute infections of the nose, sinuses, throat or larynx (upper respiratory tract infections, URI or URTI) are sorted by the areas of the body that are mostly hurt. The common cold mostly hurts the nose, pharyngitis the throat, and sinusitis the sinuses. The symptoms come from the immune system's response to the infection, not from direct destruction by the viruses themselves. Hand washing is the main way to keep the common cold from happening. Wearing face masks might also help.\nThere is no cure for the common cold, but the symptoms can be treated. It is the most frequent infectious disease in humans. The average person gets two to three colds every year. The average child gets between six and twelve colds every year. These colds have been with humans for thousands of years.");
            //iv.setImageResource(R.drawable.common_cold);
        }

        else if("cow pox".equals(bucket)){
            tv.setText("Cowpox is a disease. This disease affects the skin. It is caused by a virus (Cowpox virus) that is related to the Vaccinia virus. People (or animals) who have the disease have red blisters. The disease can be spread by touch from cows to humans. The virus that causes cowpox was used to perform the first successful vaccination against another disease. The disease vaccinated against was the deadly smallpox. Smallpox is caused by the related Variola virus. Therefore the word \"vaccination\" has the Latin root vaca meaning cow.\nIn 1798 the English physician Edward Jenner made a curious observation. Jenner lived in the countryside, not in the city. Some of his patients had gotten cowpox, and recovered from it. He observed that those patients did not get the disease again, they seemed to be immune against it. What was more, they also seemed to be immune against smallpox. Smallpox was a deadly disease then, that killed most of the people it infected. So he used the fluid he got from cowpox lesions, and scratched it into healthy people. That way, he could make those people immune against smallpox.\nThe Cowpox (Catpox) virus is found in Europe and mainly in the UK. Human cases are very rare and most often contracted from domestic cats. The virus is not commonly found in cows; the reservoir hosts for the virus are woodland rodents particularly voles. It is from these rodents that domestic cats get the virus. Symptoms in cats include lesions on the face, neck, forelimbs, and paws, and less commonly upper respiratory tract infection.[1] Symptoms of infection with cowpox virus in humans are localized, pustular lesions generally found on the hands and limited to the site of introduction. The incubation period (the time between an infectionm and the first signs of the disease) is 9–10 days. The virus can be found mostly in late summer and autumn.");
            //iv.setImageResource(R.drawable.cow_pox);
        }

        else if("dengue".equals(bucket)){
            tv.setText("Dengue fever is an infection caused by the dengue virus. Mosquitoes transmit (or spread) the dengue virus. Dengue fever is also known as \"break-bone fever\" or \"bone-break fever\", because it can cause people to have pain so bad that they feel like their bones are breaking. Some of the symptoms of dengue fever are fever; headache; a skin rash that looks like measles; and pain in the muscles and joints. In a few people, dengue fever can turn into one of two forms that are life-threatening. The first is dengue hemorrhagic fever, which causes bleeding, leaking blood vessels (tubes which carry blood), and low levels of blood platelets (which cause the blood to clot). The second is dengue shock syndrome, which causes dangerously low blood pressure.\nThere are four different types of the dengue virus. Once a person has been infected with one type of the virus, he usually is protected from that type for the rest of his life. However, he will only be protected against the other three types of the virus for a short time. If he later gets one of those three types of the virus, he will be more likely to have serious problems.\nThere is no vaccine that works to keep people from getting the dengue virus. There are a few things that can be done to prevent people from getting dengue fever. People can protect themselves against mosquitoes and limit the number of bites they get. Scientists also suggest making mosquito habitats smaller and reducing the number of mosquitoes that exist. Once a person has dengue fever, he usually can recover just by drinking enough fluids, as long as his disease is mild or moderate. If the person has a more severe case, he may need intravenous fluids (fluids given into a vein, using a needle and tubing), or blood transfusions (being given blood from another person).");
            //iv.setImageResource(R.drawable.dengue);
        }

        else if("diabetes".equals(bucket)){
            tv.setText("Diabetes is the condition that results from lack of insulin in a person's blood, or when their body has a problem using the insulin it produces (Insulin resistance). There are other kinds of diabetes, like diabetes insipidus. However, when people say \"diabetes\", they usually mean diabetes mellitus. People with diabetes mellitus are called \"diabetics\".\nGlucose is not regular sugar that is available in stores and supermarkets. Glucose is a natural carbohydrate that our bodies use as a source of energy. The kind of sugar sold in supermarkets is called sucrose, and is much different from glucose. High concentrations of glucose can be found in soft drinks and fruits.[1]\nGlucose level in the blood is controlled by several hormones. Hormones are chemicals in your body that send messages from cells to other cells. Insulin is a hormone made by the pancreas. When you eat, the pancreas makes insulin to send a message to other cells in the body. This insulin tells the cells to take up glucose from the blood. The glucose is used by cells for energy. Extra glucose that is not needed right away is stored in some cells as glycogen. When you are not eating, cells break down glycogen into glucose to use as energy.");
            //iv.setImageResource(R.drawable.diabetes);
        }

        else if("diphtheria".equals(bucket)){
            tv.setText("Diphtheria is an infectious disease caused by a bacterium Corynebacterium diphtheriae. It can be treated by special drugs, or by antibiotics. A vaccine is available. It is feared mainly because of complications that can occur:");
            //iv.setImageResource(R.drawable.diphtheria);
        }

        else if("dehydration".equals(bucket)){
            tv.setText("Dehydration (hypohydration) means less water in something. The word comes from the ancient Greek word for water, hydor.\nWhen people are dehydrated, they have lost so much water in their body that their bodies no longer work in the right way. Dehydration is a very bad condition and if the problem is not fixed, then the person who is dehydrated can die since they do not have enough water in their bodies." +
                    "\nSymptoms:-" +
                    "\nThirst\nLittle/no urination\nWeakness\nLess tears\nDryness of the mouth\nCramps\nLow blood pressure and high pulse\nErectile dysfunction");
            //iv.setImageResource(R.drawable.dehydration);
        }

        else if("ear infection".equals(bucket)){
            tv.setText("Otitis means inflammation or infection of the ear. It can happen in both humans and other animals. It can affect different parts of the ear:\nOtitis externa, also called \"swimmer's ear\", affects the outer ear and ear canal.\nOtitis media affects the middle ear.\nOtitis interna affects the inner ear.");
            //iv.setImageResource(R.drawable.ear_infection);
        }

        else if("ebola".equals(bucket)){
            tv.setText("Ebola virus, pronounced E- Bo-la, is a very dangerous virus. It causes a hemorrhagic fever called Ebola virus disease. (\"Hemorrhagic\" means the victim bleeds a lot, inside and outside their body.) It is very dangerous. Out of every 10 people who get Ebola, on average five to nine die. There are four kinds of Ebola virus that can cause the disease. The virus was first identified in Sudan. It is found in Africa and perhaps Asia.");
            //iv.setImageResource(R.drawable.ebola);
        }

        else if("epilepsy".equals(bucket)){
            tv.setText("Epilepsy is a chronic condition of the brain. It is characterized by seizures that do not seem to have an obvious cause.[1][2] To the outside viewer, these seizures show as episodes of heavy shaking.[3] Depending on the seizure, the shaking may be short and difficult to detect or it may be longer.");
            //iv.setImageResource(R.drawable.epilepsy);
        }

        else if("fibromyalgia".equals(bucket)){
            tv.setText("Fibromyalgia is a very severe condition with chronic and extensive pain. The exact causes are not known. However, symptoms are not totally restricted to the pain. There are also sleep disturbances, joint stiffness and severe fatigue. The problem is sometimes comorbid with depression, stress and anxiety. Fibromyalgia affects mostly women, though men can also be affected. Adults are usually victims, although children may also be affected.");
            //iv.setImageResource(R.drawable.fibromyalgia);
        }

        else if("foodborne illness".equals(bucket)){
            tv.setText("Foodborne illness (also foodborne disease and colloquially referred to as food poisoning)[1] is any illness resulting from the consumption of contaminated food, pathogenic bacteria, viruses, or parasites that contaminate food,[2] as well as chemical or natural toxins such as poisonous mushrooms.");
            //iv.setImageResource(R.drawable.foodborne_illness);
        }

        else if("gangrene".equals(bucket)){
            tv.setText("Gangrene is a serious medical condition that causes the decay and death of body tissue, usually in the extremities such as the fingers and hands, and toes and feet. The two main types of gangrene are dry gangrene and wet gangrene. A third less common type is a form of wet gangrene know as gas gangrene and very rare type which affects the internal organs is known as internal gangrene.\nDry gangrene is usually caused by a loss of blood supply to the affected area, such as may happen following an injury which damages the blood vessels to the affected area. Wet gangrene usually occurs when a wound becomes infected with various types of bacteria. Gas gangrene is usually caused by clostridium bacteria and mainly affects the muscles. Internal gangrene affects the internal organs usually the intestines, gallbladder or appendix.");
            //iv.setImageResource(R.drawable.gangrene);
        }

        else if("goitre".equals(bucket)){
            tv.setText("A goitre or goiter (Latin: struma), also called a bronchocele, is a swelling in the neck (just below Adam's apple or larynx) due to an enlarged thyroid gland .The thyroid gland's enlargement usually occurs due to deficiency of iodine.");
            //iv.setImageResource(R.drawable.goitre);
        }

        else if("gonorrhea".equals(bucket)){
            tv.setText("Gonorrhea is a disease. It is transmitted by having sex. It is among the most widespread sexually transmitted diseases. Gonorrhea is also sometimes called \"the clap.\" Gonorrhea can be cured using antibiotics but the entire course of antibiotics must be used.");
            //iv.setImageResource(R.drawable.gonorrhea);
        }

        else if("heart disease".equals(bucket)){
            tv.setText("Heart disease is a general term that means that the heart is not working normally. Babies can be born with heart disease. This is called congenital heart disease. If people get heart disease later, it is called acquired heart disease. Most heart disease is acquired." +
                    "\nSYMPTOMS:-" +
                    "\nA person can have heart disease and not feel sick. Some people with heart disease have symptoms. This is when there are changes or pain in the body to show a disease is there. Some symptoms of heart disease are:\nPain in the chest--the heart muscle is not getting enough flow to keep it going.\nTrouble breathing--blood may back up into the lungs.\nPalpitations (a feeling that the heart is beating too fast, too hard, or not regular).\nSwelling of feet or legs--blood is backing up from in the lower body.\nFeeling weak because the body and brain are not getting enough blood to supply them with oxygen.\nCyanosis (skin turning a blue colour) means that too little oxygen is in the bloodstream to supply the cells in the body.");
            //iv.setImageResource(R.drawable.heart_disease);
        }

        else if("hepatitis A".equals(bucket)){
            tv.setText("Hepatitis A is viral infection of the liver caused by the hepatitis A virus. Unlike the other common forms of hepatitis (hepatitis B and C) it does not cause chronic liver disease.");
            //iv.setImageResource(R.drawable.hepatitis_a);
        }

        else if("hepatitis B".equals(bucket)){
            tv.setText("Hepatitis B is a disease of the liver. It is caused by a virus. The virus is not spread by food or casual contact. It can be spread by blood or body fluids from an infected person. A baby can get it from its mother during childbirth. It can also be spread by sexual contact,[1] reuse of needles,[2] and transfusions of blood with the virus in it.[3]\nInfection with hepatitis B can be prevented by vaccination, where an injection is given which makes the body immune to the virus. It is recommended that all people are given a series of three vaccines over a few months when they are babies to ensure good protection against this virus. However, vaccination only provides 90% protection, it does not completely remove the risk of infection.[4]\nSome people who are infected are able to beat the virus quickly. Many people are infected for life. Usually they have few or no symptoms. Sometimes the liver is damaged severely, causing liver failure. A common symptom of liver failure is jaundice, where the person's skin and eyes turn yellow due to a build-up of body products which would normally be filtered by the liver. Another problem with hepatitis B is that it can cause cancer of the liver.[5]\nBlood tests can find signs that the liver is being damaged. If people have those signs, treatment for hepatitis B can prevent the liver damage caused by the virus. Antiviral medications are given, which prevent the virus from making copies of itself. However, once the virus is in the liver, it is not possible to get rid of the virus completely.");
            //iv.setImageResource(R.drawable.hepatitis_b);
        }

        else if("hepatitis C".equals(bucket)){
            tv.setText("Hepatitis C is an infection that mostly affects the liver. The hepatitis C virus (HCV) causes this disease.[1] Often, a person with Hepatitis C does not have any symptoms (health problems or signs that he has the disease). However, chronic infection can scar the liver. Many years of infection may cause cirrhosis. Sometimes, people with cirrhosis also have liver failure or liver cancer. They can also have very swollen veins of the esophagus and stomach. The blood loss from this problem can kill.[1]\nHepatitis C is usually spread by blood-to-blood contact (when blood from a person with Hepatitis C contacts (touches or gets into) another person's bloodstream). The most common ways that this happens are through intravenous drug use (when a person shoots drugs into one of their veins, with a needle that was already used by a person infected with Hepatitis C); nonsterile medical equipment (medical tools that were not cleaned well enough after being used on an infected person); and blood transfusions (when a person is given blood that came from an infected person).\nAround the world, about 130–170 million people have Hepatitis C. Scientists began studying the Hepatitis C virus in the 1970s, and in 1989 they proved that the virus exists.[2] As far as scientists know, this virus does not cause disease in any animals other than humans.\nThe medications that are normally used to treat Hepatitis C are called peginterferon and ribavirin. Between 50-80% of people who are treated (or 5 to 8 out of every 10) are cured. However, if a person's Hepatitis C has progressed (or gotten worse) so much that the person has cirrhosis or liver cancer, the person might need a liver transplant (they might need to have surgery where they are given another person's liver, or part of another person's liver). This makes it possible for the person to survive, but the Hepatitis C virus usually comes back after the transplant.[3] There is no vaccine that works to prevent people from getting Hepatitis C.");
            //iv.setImageResource(R.drawable.hepatitis_c);
        }

        else if("hepatitis D".equals(bucket)){
            tv.setText("Hepatitis D, also referred to as hepatitis D virus (HDV) and classified as Hepatitis delta virus, is a disease caused by a small circular enveloped RNA virus. It is one of five known hepatitis viruses: A, B, C, D, and E. HDV is considered to be a subviral satellite because it can propagate only in the presence of the hepatitis B virus (HBV).[1] Transmission of HDV can occur either via simultaneous infection with HBV (coinfection) or superimposed on chronic hepatitis B or hepatitis B carrier state (superinfection).");
            //iv.setImageResource(R.drawable.hepatitis_d);
        }

        else if("hepatitis E".equals(bucket)){
            tv.setText("Hepatitis E is a viral hepatitis (liver inflammation) caused by infection with a virus called hepatitis E virus (HEV). HEV is a positive-sense single-stranded RNA icosahedral virus with a 7.5 kilobase genome. HEV has a fecal-oral transmission route. It is one of five known hepatitis viruses: A, B, C, D, and E. Infection with this virus was first documented in 1955 during an outbreak in New Delhi, India.[1] A preventative vaccine (HEV 239) is approved for use in China.");
            //iv.setImageResource(R.drawable.hepatitis_e);
        }

        else if("hiv".equals(bucket)){
            tv.setText("Human immunodeficiency virus (HIV) is a type of virus called a retrovirus, which infects the human immune system (the system in the body which is in charge of fighting off illness). HIV may cause AIDS (a collection of diseases and symptoms, or problems in the body) by eventually killing the white blood cells, which a healthy body uses to fight off disease.");
            //iv.setImageResource(R.drawable.hiv);
        }

        else if("hypermetropia".equals(bucket)){
            tv.setText("Hyperopia or hypermetropia, from the Greek word \"hyper-metropia : ὑπερ-μετρωπία\" commonly known as being farsighted (American English) or longsighted (British English), is a defect of vision caused by an imperfection in the eye (often when the eyeball is too short or the lens cannot become round enough), causing difficulty focusing on near objects, and in extreme cases causing a sufferer to be unable to focus on objects at any distance. As an object moves toward the eye, the eye must increase its optical power to keep the image in focus on the retina. If the power of the cornea and lens is insufficient, as in hyperopia, the image will appear blurred.");
            //iv.setImageResource(R.drawable.hypermetropia);
        }

        else if("hypotonia".equals(bucket)){
            tv.setText("Hypotonia is a state of low muscle tone[1] (the amount of tension or resistance to stretch in a muscle), often involving reduced muscle strength. Hypotonia is not a specific medical disorder, but a potential manifestation of many different diseases and disorders that affect motor nerve control by the brain or muscle strength. Recognizing hypotonia, even in early infancy, is usually relatively straightforward, but diagnosing the underlying cause can be difficult and often unsuccessful. The long-term effects of hypotonia on a child's development and later life depend primarily on the severity of the muscle weakness and the nature of the cause. Some disorders have a specific treatment but the principal treatment for most hypotonia of idiopathic or neurologic cause is physical therapy, occupational therapy for remediation, and/or music therapy.");
            //iv.setImageResource(R.drawable.hypotonia);
        }

        else if("infertility".equals(bucket)){
            tv.setText("Infertile means not able to have children or other offspring. Humans can be infertile, but animals and plants can too. When a human couple is infertile, they sometimes have fertility treatment to have children. This can be insemination or IVF. They also sometimes adopt a child.");
            //iv.setImageResource(R.drawable.infertility);
        }

        else if("influenza".equals(bucket)){
            tv.setText("Influenza, better known as the flu and sometimes called the grippe, is a common childhood illness, but is not as common among adults. It is not limited to humans, most mammals and many birds can also catch influenza. It is caused by several different viruses (see: RNA virus), which is why people can have the flu more than once.. The name influenza comes from Italian: influenza, meaning \"influence\".");
            //iv.setImageResource(R.drawable.influenza);
        }

        else if("iritis".equals(bucket)){
            tv.setText("Uveitis is, broadly, inflammation of the uvea. The uvea consists of the middle, pigmented vascular structures of the eye and includes the iris, ciliary body, and choroid. Uveitis requires an urgent referral and thorough examination by an optometrist or ophthalmologist and urgent treatment to control the inflammation.");
            //iv.setImageResource(R.drawable.iritis);
        }

        else if("jaundice".equals(bucket)){
            tv.setText("Jaundice (also called icterus) is when the skin and the whites of the eyes become a yellow color.[1] People with jaundice have a problem with their liver, which stops it from removing dead red blood cells properly. These blood cells contain a chemical called bilirubin.[1] Bilirubin causes the yellow coloring of the skin. Jaundice is common in newly born babies. It usually starts the second day after birth.[2]\nJaundice can also be caused by other diseases, like malaria, hepatitis, or gallstones.\nJaundice is the most common of all liver problems. The yellow colour of the skin and mucous membranes happens because of an increase in the bile pigment, bilirubin, in the blood.[2]\nThe bile, made by the liver, is a vital digestive fluid needed for proper nutrition. It also stops decaying changes in food. If the bile is stopped from entering the intestines there is an increase in gases and other products. Normally, the production of bile and its flow is constant.");
            //iv.setImageResource(R.drawable.jaundice);
        }

        else if("keloids".equals(bucket)){
            tv.setText("A keloid is a type of scar that can form where somebody has an injury.[1] Keloids are tough and get larger over time, not going away. They can become as big as 30 centimeters long. They are shaped irregularly, rising high above the skin.");
            //iv.setImageResource(R.drawable.keloids);
        }

        else if("kuru".equals(bucket)){
            tv.setText("Kuru is a disease caused by cannibalism, specifically eating human brains. It is also known as the \"laughing sickness\" due to the pathologic bursts of laughter that the patient displays.");
            //iv.setImageResource(R.drawable.kuru);
        }

        else if("lead poisoning".equals(bucket)){
            tv.setText("Lead poisoning is a condition where there is too much lead in the body. Lead inerferes with many processes, and is toxic to many organs and tissues. Treatment of the condition is usually focused on removing the source of lead.");
        }

        else if("leukemia".equals(bucket)){
            tv.setText("Leukemia or leukaemia is a cancer of blood and bone marrow. When a person has leukemia, the body makes too many white blood cells (leukocytes).\nThere are many kinds of leukemia. Leukemias are part of a bigger group of diseases, the blood cancers (hematological neoplasms). Without treatment, leukemia may lead to death within weeks, months, or years. How long the person lives depends on the kind of leukemia.\nIn 2000, about 256,000 children and adults around the world developed some form of leukemia, and 209,000 died from it.[1] About 90% of all leukemias are seen in adults.");
            //iv.setImageResource(R.drawable.leukemia);
        }

        else if("lung cancer".equals(bucket)){
            tv.setText("Lung cancer is the uncontrolled growth of abnormal cells in one or both of the lungs. Cigarette smoking causes most lung cancers. Lung cancer kills 1.3 million people each year, more than any other cancer. It is currently the leading cause of cancer death in both men and women, it kills more women than breast cancer, ovarian cancer and uterine cancers together.\nThe large majority of people who get lung cancer have smoked for many years. However, there are types of lung cancers that appear in otherwise healthy patients who have never smoked.\nThere are two main types of lung cancer, small cell lung cancer and non-small cell lung cancer. Small cell lung cancer typically responds well to chemotherapy and radiotherapy, and non-small cell lung cancer is more commonly treated with surgical removal of the lung tumor.");
            //iv.setImageResource(R.drawable.lung_cancer);
        }

        else if("malaria".equals(bucket)){
            tv.setText("Malaria is an infectious disease caused by a parasite: it is spread by the bite of an infected mosquito. People catch malaria when the parasite enters the blood. The parasite causes a deadly infection which kills many people each year.\nThe parasite that causes malaria is a protozoan called Plasmodium. Protozoa are organisms with only one cell, but they are not bacteria. Bacteria are smaller and simpler than protozoa.\nPeople usually get malaria from the Anopheles or Culex mosquitoes: they are the vectors of the disease. The Plasmodium gets into people by the bites of mosquitoes. The Plasmodium is in the mosquito's special saliva.[1] The mosquito's saliva injects an anticoagulant into the person to prevent their blood from clotting. The person is then infected with Plasmodium as a by-product. This makes the person have the disease we call malaria.\nOnly the female mosquito gives people malaria, because only the female mosquito consumes blood. The male mosquito lives on the nectar of flowers. The female uses blood as a source of protein for its eggs.\nSome people do not get malaria from mosquitoes. A baby can get it while inside its mother. This is called maternal-foetal transmission. People can also get malaria from a blood transfusion. This is when someone gives blood to another person. Another way people can catch malaria is by using a needle that someone with the disease used before them.");
            //iv.setImageResource(R.drawable.malaria);
        }

        else if("measles".equals(bucket)){
            tv.setText("Measles is an infectious disease, caused by a virus. People catch measles from other people. It is passed on in tiny drops of water when people breathe. People with measles have a sore throat, a fever, a cough, red eyes and a runny nose. They also have a bumpy red rash all over their body. These rashes will cause a high irritation of itching.\nMeasles is very infectious, which means it is easy to catch. If someone in a house has measles, it is very likely that other people in the house will also get it. In developed countries, lots of children have a vaccination (injection) to stop them from getting measles. Often they are given the MMR vaccine, to stop them getting measles, mumps and rubella. The three vaccinations are all in one injection.\nMeasles is sometimes also called rubeola, but it is not the same as rubella (German measles). The German Measles (rubella) was discovered by German scientists.\nThere is no cure for measles. People with measles may rest and take medicines to make them feel better, to stop pain and make fevers go away. Most people that have measles recover, but some people die from it.");
            //iv.setImageResource(R.drawable.measles);
        }

        else if("melanoma".equals(bucket)){
            tv.setText("Melanoma (pronounced /ˌmɛləˈnoʊmə/) is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye (see uveal melanoma). It is one of the rarer types of skin cancer but causes the majority of skin cancer related deaths. Malignant melanoma is a serious type of skin cancer. It is due to uncontrolled growth of pigment cells, called melanocytes.[1][2] According to a report by the WHO, about 48,000 people die of melanoma every year.\nMelanoma that has metastasised (spread beyond the initial primary tumor) is treated with Dacarbizine or Interleukin-2, also known as Proleukin, in many cases. Interleukin-2 has a response rate of up to sixteen-percent.[4] Recent studies support the use of a new drug called Ipilimumab, which appears to prolong survival in metastatic melanoma patients.[5] Percutaneous liver perfusion with a chemotherapeutic agent known as melphalan can prolong progression free survival in patients with melanoma metastatic to the liver, although the majority of patients in this study had melanoma starting in the eye rather than the skin.");
            //iv.setImageResource(R.drawable.melanoma);
        }

        else if("migraine".equals(bucket)){
            tv.setText("A migraine is a medical condition which usually causes a pounding, throbbing headache on one side of the head. The pain may be very bad and hurt so much that a person may have a hard time doing anything. While most people who have migraines get a headache, not everyone does. There are different kinds of migraines and some do not cause a headache but do have other symptoms.\nMost migraines cause a headache and nausea and might make the person dizzy or very sensitive to bright lights or loud noises. Some people have \"auras\" before a migraine starts, which means their ability to see becomes different. They may see funny patterns, have blurry vision, or may not be able to see at all. Other senses can change before or during a migraine, and the person may sense funny smells or tastes. Migraines can last a long time. Most migraines only last about 4 hours. Some can last up to 72 hours.\nMigraines have been classified, based on how often they happen in a month: If a person has a headache for less than fifteen days, the migraine is called episodic migraine (EM). If it happens more than fifteen days, it is called chronic migraine (CM). Chronic means it happens over a long amount of time. Some people who start off getting episodic migraines may start to get chronic migraines later. Chronic migraine then may revert or go back to episodic migraine.");
            //iv.setImageResource(R.drawable.migraine);
        }

        else if("mumps".equals(bucket)){
            tv.setText("Mumps is a viral disease of the human species. Some of the most commons symptoms can be fever, headaches, swelling of the parotid glands, sore throats, and orchitis (which means swelling of the testicles).\nhis can be diagnosed by the increase in alpha amylase isoenzymes in blood plasma.\nThe MMR vaccination stops measles, mumps and rubella");
            //iv.setImageResource(R.drawable.mumps);
        }

        else if("myopia".equals(bucket)){
            tv.setText("Myopia, also called near- or short-sightedness, is a problem with the focusing ability of the eye. It is when the eye is not able to focus properly on objects in the distance. This condition is very common and it often occurs with many members of the same family. It happens when the cornea becomes a different shape (too curved) from normal or when the eye is longer than normal and so causes light entering the eye to focus on a point within the eye before the retina. This causes the eye and brain to see the image of the distant object as a blurred image. People with myopia often squint while watching television or trying to see distant objects. Myopia can often be the first symptom of Type II Diabetes.\nIt can be corrected by using glasses, contact lenses, or surgery. Myopia can also be corrected by practicing looking at distant objects.");
            //iv.setImageResource(R.drawable.myopia);
        }

        else if("necrotizing fasciitis".equals(bucket)){
            tv.setText("Necrotizing fasciitis is a major, but rare, condition that affects deep layers of human skin and tissues. The problem is treated very quickly under antibiotics. Many people with the condition may also have other issues, such as diabetes. The condition is caused by bacteria. Other names for the disease are flesh-eating disease or flesh-eating bacteria syndrome.");
            //iv.setImageResource(R.drawable.necrotizing_fasciitis);
        }

        else if("night blindness".equals(bucket)){
            tv.setText("Nyctalopia (Greek for Night blindness) is a disease of the human eyes.The eyes of people who are night-blind cannot adapt to situations where there is relatively little light; as a result, they have trouble seeing in such situations.\nThere are a number of conditions that can cause this; most commonly:\nlack or deficiency of Vitamin A\nSeveral genetic conditions, most notably retinitis pigmentosa\nWounds of the eye");
            //iv.setImageResource(R.drawable.night_blindness);
        }

        else if("obesity".equals(bucket)){
            tv.setText("Obesity is the condition of being much too heavy for one's height so that one's health is affected. In other words, it means to be too overweight. Also known as being fat. It is considered a disease[1] and has been described as an epidemic.\nTo know if a person is overweight, the body mass index (BMI) is calculated, by dividing the person's weight (in kilograms), by their height (in meters) squared (multiplied by itself). (This is only meaningful for adults who are fully grown, and should not be used for children. Growth charts can be used to measure obesity in children.)\nA BMI between 20 and 25 is considered normal. People with a BMI of 25 or more are said to be overweight; with 30 and above, they are considered obese, and with 35 and above, they are considered severely obese (this used to be called morbidly obese). In general, the BMI number is a good quantifiable measurement of a person's obesity, however it is a poor predictor in people who are very athletic, because a person with a higher than average amount of muscle tissue will weigh more than an average person, thus resulting in a BMI that is higher than normal, even if that person is very large.");
            //iv.setImageResource(R.drawable.obesity);
        }

        else if("osteoarthritis".equals(bucket)){
            tv.setText("Osteoarthritis normally affects older people: it is the disease where joints wear out. As the joint surface wears away, it sheds particles which stimulate the joint lining to produce fluid. This causes the joint to swell. When the joint cartilage wears away, the core of the bone becomes exposed. The exposed bone rubs against other exposed bone.");
            //iv.setImageResource(R.drawable.osteoarthritis);
        }

        else if("osteoporosis".equals(bucket)){
            tv.setText("Osteoporosis is the weakening of bones in the body. It is caused by lack of calcium deposited in the bones. This lack of calcium causes the bones to become brittle, so they break easily. Some side effects are limping. Some symptoms late in the disease include pain in the bones, living in a wheelchair (as a result of), and lower back pain due to spinal bone fractures.[1] Elderly people are more likely to develop osteoporosis than younger people. The amount of calcium in the bones decreases as a person gets older. There are three kinds of osteoporosis.\nIt is more likely for a woman to get osteoporosis than a man.");
            //iv.setImageResource(R.drawable.osteoporosis);
        }

        else if("otitis".equals(bucket)){
            tv.setText("Otitis means inflammation or infection of the ear. It can happen in both humans and other animals. It can affect different parts of the ear:");
            //iv.setImageResource(R.drawable.otitis);
        }

        else if("paratyphoid fever".equals(bucket)){
            tv.setText("Paratyphoid fever, also known as enteric fever, is a waterborne disease caused by the bacterium Salmonella Paratyphi. It is related to Typhoid fever, but like Typhoid, it is unrelated to Typhus. Symptoms include:\nFever,\nAbdominal pain\nSwelling of the liver or spleen\nSlow heart rate.\nThe disease is rarely fatal and people usually recover in a few days, but some people can carry the bacteria for months.");
            //iv.setImageResource(R.drawable.paratyphoid_fever);
        }

        else if("pertussis".equals(bucket)){
            tv.setText("Pertussis, also known as whooping cough, is a disease that kills about 300,000 people in the world every year, out of 30–50 million cases per year. There is a vaccine that can prevent it, so most cases of it are in places where people cannot afford, or cannot get, the vaccine. However, this vaccine does not work forever. The disease lasts about 6 weeks, and symptoms include vomiting, violent coughing, and other flu-like symptoms. It is called whooping cough for the sound an infected person makes when they cough.\nThe disease usually infects younger people, as they are more prone to diseases.");
            //iv.setImageResource(R.drawable.pertussis);
        }

        else if("plague".equals(bucket)){
            tv.setText("Bubonic plague is the best-known form of the disease plague, which is caused by the bacterium Yersinia pestis. The name bubonic plague is specific for this form of the disease, which enters through the skin, and travels through the lymphatic system.\nIf the disease is left untreated, it kills about half its victims, in between three and seven days. The bubonic plague was the disease that caused the Black Death, which killed tens of millions of people in Europe, in the Middle Ages.[1]\nSymptoms of this disease include coughing, fever, and black spots on the skin.");
            //iv.setImageResource(R.drawable.plague);
        }

        else if("porphyria".equals(bucket)){
            tv.setText("Porphyria is the name for certain medical conditions or diseases. Those who suffer from the disease can not make certain substances in the blood. The condition may be because of a genetic deficiency or because it was acquired in some way. This will manifest in either skin problems, or some diseases of the nervous system, or both. Drugs are available that can at least treat the symptoms. This disease is most common in European countries and often affects the skin. When someone is affected by Porphyria they will start to lose their hair about two weeks after having an attack. There is no cure for the hair loss. However, there is medication available to help prevent attacks.");
            //iv.setImageResource(R.drawable.porphyria);
        }

        else if("pilia".equals(bucket)){
            tv.setText("Pilia is a spider genus of the Salticidae family (jumping spiders).");
            //iv.setImageResource(R.drawable.pilia);
        }

        else if("pneumonia".equals(bucket)){
            tv.setText("Pneumonia is a disease of the lungs and the respiratory system. The lung contains many small bulbs, or sacs, called alveoli. These help to take out oxygen from the air. In the case of pneumonia, these bulbs become inflamed. They fill up with a fluid, and can no longer absorb as much oxygen as before.\nPneumonia can be caused by bacteria, viruses, fungi or parasites. It can also be caused by chemical or physical damage done to the lungs. Other illnesses, like alcohol abuse or lung cancer, can also result in pneumonia.\nPeople with pneumonia usually have difficulty breathing. They may also cough, or have pains in the chest area. The treatment of pneumonia depends on how the illness was caused. If it was caused by bacteria, antibiotics can be used to treat it.\nPeople of all ages can have pneumonia. The disease is dangerous. Many people die from pneumonia, especially old people, or people with a weak immune system.");
            //iv.setImageResource(R.drawable.pneumonia);
        }

        else if("Q fever".equals(bucket)){
            tv.setText("Q fever is a disease caused by Coxiella burnetii, bacteria that affect humans and other animals. It is not common but can be found in cattle, sheep, goats, and other household animals, including cats and dogs. People can get infected if they inhale endospores or touch the milk, urine, feces, vaginal mucus, or semen of infected animals. The disease is rarely carried by ticks. A human can be infected by a single bacterium.");
            //iv.setImageResource(R.drawable.q_fever);
        }

        else if("rabies".equals(bucket)){
            tv.setText("Rabies is a neurotropic virus, viral zoonotic disease that causes acute encephalitis.\nUsually, people (and animals) die from it (it is fatal). There is no cure for it. People who are treated soon after becoming infected have a chance to survive.\nThe disease is transmitted through the saliva and the blood. The usual form of getting is a bite of a rabid mammal. Pets, like dogs need to be vaccinated against it, in most countries.");
            //iv.setImageResource(R.drawable.rabies);
        }

        else if("repetitive strain injury".equals(bucket)){
            tv.setText("Repetitive strain injury (RSI), also known as occupational overuse syndrome, is a medical condition affecting the muscles and nervous system. It is usually caused by doing the same thing repeatedly or without breaks. Using a computer for long periods of time is a common way of causing this problem.\nRepetitive strain injury is described as a sudden, intense pain in affected parts of the body, often the wrists, neck, back or hands, that keeps coming back. It is different from more specific diagnoses, because RSI does not have an easily found cause. The pain is often spread across different muscle groups and inspection of the affected area usually cannot show any differences from that of a healthy person. Because of this, treatment for RSI is usually limited to rest and exercises, and sometimes wearing a brace.");
            //iv.setImageResource(R.drawable.repetitive_strain_injury);
        }

        else if("rickets".equals(bucket)){
            tv.setText("Rickets is a disease in young children. It is caused by deficiency of vitamin D and calcium. Rickets causes larger gaps inside bones and turns them dry and spongy. It also makes a curve on the legs.\nThe word \"rickets\" comes from the Greek word rhakhis, which means \"spine\". People can get rickets if they:\nhave a dark skin colour\nspend too little time outside\nalways wear sunscreen when going out\ndo not eat food containing vitamin D because of lactose intolerance or a strict vegetarian diet\ncannot make or use vitamin D because of a medical disorder such as coeliac disease");
            //iv.setImageResource(R.drawable.rickets);
        }

        else if("rubella".equals(bucket)){
            tv.setText("Rubella (also known as German measles) is a disease caused by the Rubella virus.\nIt is often mild and an attack can pass unnoticed. However, this can make the virus very difficult to diagnose. The virus usually enters the body through the nose or throat. The disease can last 1–5 days. Children recover more quickly than adults. Like most viruses living along the respiratory tract, it is passed from person to person by tiny droplets in the air that are breathed out. Rubella can also be transmitted from a mother to her developing baby through the bloodstream through the placenta. The virus has an incubation period of 2 to 3 weeks during which it becomes established. Common symptoms are a red/pink rash, swollen lymph nodes, a high temperature.\nThe disease is named German measles because it has a similar red rash to measles and was first described in detail by German physicians.");
            //iv.setImageResource(R.drawable.rubella);
        }

        else if("rheumatic fever".equals(bucket)){
            tv.setText("Rheumatic fever is an inflammatory disease that happens in children and young adults as a result of becoming infected by group A streptococci bacteria. The first attack usually happens between the ages of 5 and 15. It affects the heart, skin, joints and the central nervous system. It is most common in the Middle East, eastern Europe, South America and the Far East and is rare in western Europe and North America. Treatment includes resting in bed and antibiotics.");
            //iv.setImageResource(R.drawable.rheumatic_fever);
        }

        else if("scabies".equals(bucket)){
            tv.setText("Scabies (from Latin: scabere, \"to scratch\"),[1] also known colloquially as the seven-year itch,[2] is a contagious skin infection caused by the mite Sarcoptes scabiei. The mite is a tiny, and usually not directly visible, parasite which burrows under the host's skin, which in most people causes an intense itching sensation caused by an allergic response. The infection in animals other than humans is caused by a different but related mite species, and is called sarcoptic mange.\nScabies is classified by the World Health Organization as a water-related disease.[3] The disease may be transmitted from objects, but is most often transmitted by direct skin-to-skin contact, with a higher risk with prolonged contact. Initial infections require four to six weeks to become symptomatic. Reinfection, however, may manifest symptoms within as few as 24 hours. Because the symptoms are allergic, their delay in onset is often mirrored by a significant delay in relief after the parasites have been eradicated. Crusted scabies, formerly known as Norwegian scabies, is a more severe form of the infection often associated with immunosuppression.");
            //iv.setImageResource(R.drawable.scabies);
        }

        else if("scarlet fever".equals(bucket)){
            tv.setText("Scarlet fever is an infectious disease that is caused by bacteria. It is caused by exotoxin released by Streptococcus pyogenes. It was once a major cause of death. It is now treated with antibiotics. The term scarlatina can be used to mean scarlet fever. Scarlatina is lesser form of scarlet fever.");
            //iv.setImageResource(R.drawable.scarlet_fever);
        }

        else if("scurvy".equals(bucket)){
            tv.setText("Scurvy is a disease caused by not eating enough vitamin C. People who have scurvy get spots on their skin, especially at the legs. Their teeth may loosen and fall out. They may bleed from the mouth, nose, and gums (mucous membranes). A person with scurvy will look pale and feel sad (see depression). They will not be able to move easily, because their joints hurt.\nIn the past, sailors used to get scurvy because fresh fruit and meat could not be kept for as long as they were at sea. In 1747, James Lind discovered that this was the main cause of scurvy. Not many people get scurvy now in rich countries.");
            //iv.setImageResource(R.drawable.scurvy);
        }


        else if("small pox".equals(bucket)){
            tv.setText("Smallpox was a very bad disease with a high mortality rate. It is caused by a virus. There are two different species of viruses that can cause the disease. They are Variola major and Variola minor. Some people also call smallpox Variola, named after the viruses' scientific name.\nOnly humans can get this disease. Variola major kills between 20% and 40% of those who get it. Variola minor kills only about 1%. Many people who survive become blind because of the damage the virus does to the eyes.\nDuring the first half of the 20th century, between 300 million and 500 million people died of this disease. Even in 1967, about 15 million people caught the disease, and about two million people died of it, according to the World Health Organization (WHO).\nThe first vaccine for smallpox used the results of cowpox infections. It was invented by Edward Jenner. It was used to stop people from getting smallpox. The word \"vaccine\" came from \"vaccina\", the Latin word for cow, because cowpox was used. The WHO (World Health Organisation) said that they were trying to eradicate (completely destroy) smallpox in 1963. They vaccinated people all over the world. In 1980, the WHO said the disease no longer existed,[2] and no one would ever get sick from it again. However, live copies of smallpox are kept in different maximum-security laboratories around the world.");
            //iv.setImageResource(R.drawable.small_pox);
        }

        else if("stomach flu".equals(bucket)){
            tv.setText("astroenteritis is a medical term for inflammation of the stomach and intestines. It causes diarrhea, vomiting and stomach pain. It usually happens because of infection by a virus or bacteria.\nOther common terms for gastroenteritis include: infectious diarrhea, stomach bug, and stomach virus. It is sometimes called stomach flu or gastric flu, but it is not related to the influenza virus (which is often shortened to 'flu').");
            //iv.setImageResource(R.drawable.stomach_flu);
        }

        else if("stomach ulcers".equals(bucket)){
            tv.setText("A peptic ulcer is an ulcer of the stomach or duodenum. The duodenum is the first part of the small intestines. It is the tube that food goes through when it leaves the stomach. Peptic means talking about the stomach.\nGastric ulcers are peptic ulcers in the stomach.\nDuodenal ulcers are peptic ulcers in the duodenum.");
            //iv.setImageResource(R.drawable.stomach_ulcers);
        }

        else if("swine influenza".equals(bucket)){
            tv.setText("Swine influenza virus is a virus that is common in pigs. This type of influenza virus can also infect humans and birds. Swine influenza virus is sometimes called SIV or swine flu.\nSwine flu is common in pigs. Normally, it only infects people who have been in close contact with pigs. However, the disease has also spread from one person to another.[1] Swine flu can cause fever, disorientation (not being clear-headed), stiffness of the joints, vomiting, and loss of consciousness. Sometimes this ends in death.");
            //iv.setImageResource(R.drawable.swine_influenza);
        }

        else if("silicosis".equals(bucket)){
            tv.setText("Silicosis is a disease that is caused by small particles of silica (glass) getting trapped in the lungs. When people have Silicosis, the changes in their body often are cyanosis (when skin goes a blueish color), a fever, when the body gets hotter or being not able to breathe properly. Sometimes doctors do not realize that someone has Silicosis, and think that they have other illnesses like Pneumonia, Tuberculosis or fluid in the lungs.");
            //iv.setImageResource(R.drawable.silicosis);
        }

        else if("tennis elbow".equals(bucket)){
            tv.setText("Tennis elbow or archer's elbow is a condition where the outer part of the elbow becomes sore and tender. It is often associated with playing tennis, golf or other kinds of sport that use a racquet.\nThe following can cause the condition:\nOnly using part of the elbow; this can happen with mouse/keyboard users (called Repetitive strain injury), or with certain forms of mountain climbing.\nKeeping the body in a bad tenure/positioning\nWrong technique in sports that use clubs or racquets (such as tennis or golf)");
            //iv.setImageResource(R.drawable.tennis_elbow);
        }

        else if("tetanus".equals(bucket)){
            tv.setText("Tetanus is a disease that leads to muscle contractions that stay that way for some time.\nInfection generally occurs through wound contamination, and often involves a cut or deep puncture wound. The primary symptoms are caused by tetanospasmin, a neurotoxin produced by the anaerobic bacterium Clostridium tetani. As the infection goes on, muscle spasms develop in the jaw. This led to the common name of the condition, lockjaw. This is usually followed by difficulties with swallowing. The condition leads to general muscle stiffness and spasms in other parts of the body.[1] Infection can be prevented by proper immunization and by post-exposure prophylaxis.");
            //iv.setImageResource(R.drawable.tetanus);
        }

        else if("thrush".equals(bucket)){
            tv.setText("Candidiasis, often called yeast infection or thrush, is a type of infectious disease. It is a fungal infection (mycosis). The disease is caused by any of the Candida species of yeast. Candida albicans is the most common species.");
            //iv.setImageResource(R.drawable.thrush);
        }

        else if("tooth decay".equals(bucket)){
            tv.setText("The term dental caries refers to tooth decay or cavities in teeth. The decay results by bacterial matters creating destruction in the teeth area. Dental caries usually lead to substandard breath and bad taste. Personal hygiene caring consists of brushing and flossing daily.\n" +
                    "SYMPTOMS:-\n" +
                    "After enamel and dentin are destroyed and cavity reaches the nerves of the tooth, the tooth becomes sensitive since the nerves are exposed. Cavity may infect the jaw and sometimes cause a tooth abscess.");
            //iv.setImageResource(R.drawable.tooth_decay);
        }

        else if("tuberculosis".equals(bucket)){
            tv.setText("Tuberculosis, or TB for short, is an infectious disease caused by bacteria. It used to be called consumption.\nTB is caused by several types of mycobacteria, usually Mycobacterium tuberculosis.[1] The disease usually attacks the lungs, but it can also affect other parts of the body. The bacteria can travel through the air and spread from one person to the next. This happens when infected people cough, sneeze, or spit.[2] Between five and ten people show symptoms, for every hundred people infected.[3] In these people, the disease is called active. Tuberculosis kills more than half of the people who are infected if they do not get treatment.");
            //iv.setImageResource(R.drawable.tuberculosis);
        }

        else if("typhoid fever".equals(bucket)){
            tv.setText("Typhoid, also called typhoid fever, is an illness caused by the bacterium Salmonella Typhi. The disease is spread through water which has the Salmonella Typhi bacteria in it ( transmission is by faeco oral route)\nTyphoid usually lasts between two weeks and a month. The disease can be treated with antibiotics. If no treatment is given, between one and three out of every ten patients die. The rest usually get better after a month, at the most.\nTyphoid causes a steady fever of at least 103-104 degrees F (39-40 degrees C). Also, it can cause stomach pains, headache, being delirious (restless, excited, seeing things), and not being hungry. In some cases, flat, pink coloured spots show up on the patient's body. Sometimes there are no symptoms.\nTyphoid is not common in countries with good sanitation and clean water. For example, scientists think that there are only 400 cases a year in the United States. But around the world, there are about 21 million cases every year.[source?] For example, in the Indian subcontinent, typhoid is one of the most common diseases because of poor sanitation and lack of basic hygiene.");
            //iv.setImageResource(R.drawable.typhoid_fever);
        }

        else if("tumor".equals(bucket)){
            tv.setText("A tumour (or tumor) is tissue that is growing where it should not be. Tumours are either malignant (harmful) or benign (safe).\nThe Tasmanian Devils in Tasmania, Australia are in danger of becoming extinct because of a malignant tumour that grows on their face");
            //iv.setImageResource(R.drawable.tumor);
        }

        else if("ulcers".equals(bucket)){
            tv.setText("An ulcer is a kind of open wound. Ulcers can be on surfaces of the body. They can be on skin. They can be mucous membranes like the surface of the stomach or inside the mouth.\nUlcers start when the top layer (surface) of skin or mucous membrane is hurt. This top layer dies. When it dies, the skin or mucous membrane and opens. This leaves an open sore called an ulcer.\nUlcers can be from infection with germs. Ulcers can be from pressure on a part of the skin. Ulcers can be from substances that will burn skin or mucous membranes. When acid makes some stomach ulcers this is from burning by the acid. Ulcers can be from cancer. Ulcers can be from diseases of blood vessels. If not enough blood goes to a body part, it can get an ulcer. Stress can also sometimes cause ulcers. They are also noted to hurt a lot.");
            //iv.setImageResource(R.drawable.ulcers);
        }

        else if("uremia".equals(bucket)){
            tv.setText("Uremia is a Greek word used in English to describe the condition of a person's blood. Uremia is caused by urine products building up in the blood. If those come over the normal filtration system of the kidneys then the condition is called uremia. People with chronic renal disease or acute renal failure are usually affected by uremia.");
            //iv.setImageResource(R.drawable.uremia);
        }

        else if("uveitis".equals(bucket)){
            tv.setText("Uveitis is, broadly, inflammation of the uvea. The uvea consists of the middle, pigmented vascular structures of the eye and includes the iris, ciliary body, and choroid. Uveitis requires an urgent referral and thorough examination by an optometrist or ophthalmologist and urgent treatment to control the inflammation.");
            //iv.setImageResource(R.drawable.uveitis);
        }

        else if("varicella".equals(bucket)){
            tv.setText("Chickenpox (or chicken pox) is a disease. Usually it is children who get the disease, but adults can also get it. People who have it get blisters or spots, mostly on the body and in the face. Those blisters are filled with a liquid. At some point the blisters will drain, and the person will want to scratch them. Burst blisters usually become healthy without leaving scars, unless they become infected. The symptoms come in two or three waves, and usually include fever.");
            //iv.setImageResource(R.drawable.chicken_pox);
        }

        else if("viral fever".equals(bucket)){
            tv.setText("Influenza, commonly known as \"the flu\", is an infectious disease of birds and mammals caused by RNA viruses of the family Orthomyxoviridae, the influenza viruses. The most common symptoms are chills, fever, runny nose, sore throat, muscle pains, headache (often severe), coughing, weakness/fatigue and general discomfort. Although it is often confused with other influenza-like illnesses, especially the common cold, influenza is a more severe disease.[1] Influenza may produce nausea and vomiting, particularly in children,[2] but these symptoms are more common in the unrelated gastroenteritis, which is sometimes inaccurately referred to as \"stomach flu\" or \"24-hour flu\".");
            //iv.setImageResource(R.drawable.viral_fever);
        }

        else if("viral meningitis".equals(bucket)){
            tv.setText("Viral meningitis is an infection of the brain that is caused by a virus. It is usually caused by enteroviruses.[1] Viral meningitis is not so dangerous as meningitis that is caused by bacteria and the symptoms are often mild or similar to flu. This disease occurs mainly in the summer. Children get this infection more than adults. Children usually recover completely after a two weeks. Strong medicines are often not needed.");
            //iv.setImageResource(R.drawable.bacterial_meningitis);
        }

        else if("warts".equals(bucket)){
            tv.setText("Warts are growths on the skin. Very often they resemble solid blisters. Usually, applying pressure to a wart causes pain. Warts are causes by viruses in the HPV family. As there are many types of viruses in the HPV family, there are also many types of wart. In most cases, warts are not dangerous, but may cause a lot of pain.");
            //iv.setImageResource(R.drawable.warts);
        }

        else if("yellow fever".equals(bucket)){
            tv.setText("Yellow fever is an illness which is caused by a virus. The illness can cause bleeding problems. It is called yellow because the skin sometimes becomes yellow, like it does with jaundice. There is a vaccine which can stop the disease, but many people in Africa and South America are not vaccinated against it. The World Health Organization say that 200,000 people are made ill with yellow fever every year, and that 30,000 people die from it.The diseases that spread from mosqito and from an infected person through air, water and food to a healthy person is called communicable disease .Yellow fever is a communicable disease.\nYellow fever is spread through the bite of an infected mosquito.");
            //iv.setImageResource(R.drawable.jaundice);
        }
        else{
            tv.setText("");
            //iv.setImageResource(R.drawable.ic_launcher);
            Toast lol = Toast.makeText(this,"Search By Other Name",Toast.LENGTH_SHORT);
            lol.show();
        }

    }
}
