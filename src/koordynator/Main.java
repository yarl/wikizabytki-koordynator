package koordynator;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.swing.BoundedRangeModel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import org.wikipedia.Wiki;

/**
 * Koordynator
 * @version 0.1
 * @author Paweł 'Yarl' Marynowski (yarl@o2.pl)
 * @see https://github.com/yarl/wikizabytki-koordynator
 */
public class Main extends javax.swing.JFrame {
    private volatile boolean stopRq = false;
    
    Wiki wikipedia = new Wiki("pl.wikipedia.org");
    Wiki commons = new Wiki("commons.wikimedia.org");
    
    String output = "";
    boolean login = false;
    int toEdit = 0;
    
    public Main() {
        super("Koordynator 0.1");
        initComponents();
        
        /**
         * Scroll fixer
         * @see: http://stackoverflow.com/questions/4045722/how-to-make-jtextpane-autoscroll-only-when-scroll-bar-is-at-bottom-and-scroll-lo
         */
        scroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            BoundedRangeModel brm = scroll.getVerticalScrollBar().getModel();
            boolean wasAtBottom = true;
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!brm.getValueIsAdjusting()) {
                if (wasAtBottom)
                    brm.setValue(brm.getMaximum());
                } else
                wasAtBottom = ((brm.getValue() + brm.getExtent()) == brm.getMaximum());
            }
        }); 
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tLogin = new javax.swing.JTextField();
        tPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        bLogin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        loger = new javax.swing.JTextPane();
        bSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bStop = new javax.swing.JButton();
        bStart = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tPage = new javax.swing.JTextField();
        bOpen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tPassKeyPressed(evt);
            }
        });

        jLabel1.setText("Login i hasło");

        bLogin.setText("Loguj");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bLogin)
                    .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        loger.setContentType("text/html");
        loger.setEditable(false);
        loger.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        loger.setText("<html><body style=\"font: 10pt Verdana\"></body>\r</html>\r");
        scroll.setViewportView(loger);

        bSave.setText("Zapisz");
        bSave.setEnabled(false);
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSave)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        bStop.setText("Stop");
        bStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStopActionPerformed(evt);
            }
        });

        bStart.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bStart.setText("Start");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bStart, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bStop)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bStart)
                    .addComponent(bStop))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tPage.setText("Wikiprojekt:Wiki Lubi Zabytki/wykazy/województwo podkarpackie/powiat sanocki/Gmina Bukowsko");

        bOpen.setText("Otwórz w przeglądarce");
        bOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(tPage, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bOpen)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bOpen))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
        Start();
    }//GEN-LAST:event_bStartActionPerformed

    private void tPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tPassKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) 
            bLoginActionPerformed(new ActionEvent(this, 0, null));
    }//GEN-LAST:event_tPassKeyPressed

    private void bStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStopActionPerformed
        stopRq();
    }//GEN-LAST:event_bStopActionPerformed

    private void bOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOpenActionPerformed
        if(tPage.getText().isEmpty())
            log("[błąd] Wpisz stronę\n");
        else {
            try {
                Desktop.getDesktop().browse(new URI("http://pl.wikipedia.org/wiki/"+tPage.getText().replace(" ", "_")));
            } catch (URISyntaxException ex) {
                log("[błąd] Błąd składni strony: "+ex+"\n");
            } catch (IOException ex) {
                log("[błąd] Błąd: " + ex.getLocalizedMessage() + "\n");
            }
        }
    }//GEN-LAST:event_bOpenActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        if(login) {
            try {
                log("[info] Zapisywanie...\n");
                wikipedia.edit(tPage.getText(), output, "uzupełnienie współrzędnych ([[Wikipedysta:Yarl/narzędzia#Koordynator|koordynator]])");
                bSave.setEnabled(false);
                log("[info] Zmiany zapisane\n\n");
            } catch (LoginException ex) {
                log("[błąd] Zaloguj się\n");
            } catch (IOException ex) {
                log("[info] Błąd: "+ex.getLocalizedMessage()+"\n");
            } 
        } else
            log("[błąd] Zaloguj się\n");
    }//GEN-LAST:event_bSaveActionPerformed

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        if(tLogin.getText().isEmpty() || tPass.getPassword().length==0)
            log("[błąd] Podaj login i hasło\n");
        else {
            log("[info] Logowanie do Wikipedii...\n");
            try {
                wikipedia.login(tLogin.getText(), tPass.getPassword());
                log("[info] Logowanie OK\n\n");
                bLogin.setEnabled(false);
                tLogin.setEnabled(false);
                tPass.setEnabled(false);
                login = true;
            } catch (IOException ex) {
                log("[info] Błąd: "+ex.getLocalizedMessage()+"\n");
            } catch (FailedLoginException ex) {
                log("[info] Błąd logowania\n");
            }            
        }
    }//GEN-LAST:event_bLoginActionPerformed

    private void Start() {
            toEdit = 0;
            stopRq = false;
            
            bStart.setEnabled(false);
            
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        /**
                        * Pobieranie artykułu
                        */
                        if(tPage.getText().isEmpty())
                            log("[błąd] Podaj nazwę artykułu\n");
                        else {
                            log("[info] Pobieranie tabelki WLZ...\n");
                            String input = "";
                            input = wikipedia.getPageText(tPage.getText());
                            log("[info] Pobranie OK\n\n");
                            
                            /**
                             * Zabawa z tekstem
                             */
                            String[] inputTable = input.split("\\{\\{Zabytki"); 
                            for(int i=0;i<inputTable.length;++i)
                                if(inputTable[i].startsWith(" wiersz"))
                                    inputTable[i] = "{{Zabytki" + inputTable[i];
                            
                            Wiersz[] text = new Wiersz[inputTable.length];
                            for(int i=0;i<inputTable.length;++i)
                                text[i] = new Wiersz(inputTable[i]);
                            
                            /**
                             * Dwa łyki statystyki
                             */
                            log("[tabela] Zabytów na stronie: " + (int)(text.length-1) + "\n");
                            if(text.length>1) {
                                int iKoordynaty = text.length-1;
                                int iZdjecia = text.length-1;
                                int iCommons = text.length-1;
                                
                                for(int i=1;i<text.length;++i) {
                                    //log("[wiersz "+i+"] współrzędne: " + text[i].jestKoordynaty() + 
                                    //        " | zdjęcie: " + text[i].jestZdjecie() + 
                                    //        " | galeria: " + text[i].jestCommons() + "\n");
                                    if(text[i].jestKoordynaty()) --iKoordynaty;
                                    if(text[i].jestZdjecie()) --iZdjecia;
                                    if(text[i].jestCommons()) --iCommons;
                                }
                                log("[tabela] Raport: jest " + (text.length-1-iKoordynaty) + " współrzędnych, " + (text.length-1-iZdjecia) + " zdjęć, " + (text.length-1-iCommons) + " galerii\n");
                                log("[tabela] Raport: brakuje " + iKoordynaty + " współrzędnych, " + iZdjecia + " zdjęć, " + iCommons + " galerii\n");
                                
                                if(iKoordynaty>0) {
                                    /*
                                     * Główna pętla
                                     */
                                    for(int i=1;i<text.length;++i) {
                                        if(!stopRq) {
                                        /*
                                         * Koordynaty z Commons
                                         */
                                        if(text[i].jestCommons() && !text[i].jestKoordynaty()) {
                                            logBold("\n[info] #" + i + ": Szukanie w kategorii Commons (" + text[i].zwrocCommons().replace("_", " ").trim() + ")\n");
                                            
                                            String page = "";
                                            try {
                                                page = commons.getPageText("Category:" + text[i].zwrocCommons());
                                                
                                                if(page.contains("ocation")) {
                                                    page = page.replace("}}", "}}\n");
                                                    /**
                                                    * Koordy z opisu kategorii
                                                    */
                                                    log("[commons] Wspórzędne z opisu kategorii\n");

                                                    float N_ = 0;
                                                    float E_ = 0;
                                                    String[] catText = page.split("\n");

                                                    for(int k=0;k<catText.length;++k) {
                                                        if(catText[k].toLowerCase().contains("location")) {
                                                            String[] split = catText[k].split("[\\|(\\}\\})]");
                                                            /*
                                                            * format dziesiętny
                                                            */
                                                            if(split[0].toLowerCase().contains("location dec")) {
                                                                N_ = Float.parseFloat(split[1]);
                                                                E_ = Float.parseFloat(split[2]);
                                                            }
                                                            /*
                                                            * format DMS {{Location|49|9|28.96|N|22|33|5.16|E|region:PL}}
                                                            */
                                                            else if(split[0].toLowerCase().contains("location")) {
                                                                N_ = Float.parseFloat(split[1]) + ((60*Float.parseFloat(split[2]) + Float.parseFloat(split[3]))/3600);
                                                                E_ = Float.parseFloat(split[5]) + ((60*Float.parseFloat(split[6]) + Float.parseFloat(split[7]))/3600);
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    logGreen("[commons] Współrzędne: " + N_ + ";" + E_ + "\n");
                                                    ++toEdit;
                                                    try {
                                                        text[i].zapiszKoordynaty(N_, E_);
                                                    } catch (Exception ex) {
                                                        logRed("[błąd] Błąd: "+ex.getMessage()+"\n");
                                                    }
                                                } else {
                                                    /**
                                                    * Koordy z plików
                                                    */
                                                    log("[commons] Brak współrzędnych w kategorii na Commons, zasysanie plików...\n");

                                                    String[] files = commons.getCategoryMembers(text[i].zwrocCommons(), Wiki.FILE_NAMESPACE);
                                                    if(files.length>0) {
                                                        log("[commons] Zassano " + files.length + " plików, sprawdzanie współrzędnych...\n");

                                                        /**
                                                        * Pętla plików
                                                        */
                                                        ArrayList<String> coordinates = new ArrayList<String>();
                                                        for(int j=0;j<files.length;++j) {
                                                            String[] templates = commons.getTemplates(files[j]);
                                                            /*
                                                            * Czy są współrzędne?
                                                            */
                                                            boolean flag = false;
                                                            for(int k=0;k<templates.length;++k) {
                                                                if(templates[k].toLowerCase().contains("location")) {
                                                                    templates[k] = templates[k].replace("}}", "}}\n");
                                                                    flag = true;
                                                                    break;
                                                                }
                                                            }

                                                            /*
                                                            * Jest szablon! Dawaj do listy...
                                                            */
                                                            if(flag) {
                                                                String[] fileText = commons.getPageText(files[j]).split("\n");
                                                                for(int k=0;k<fileText.length;++k) {
                                                                    if(fileText[k].toLowerCase().contains("location")) {
                                                                        //log("[commons] Mamy coordy:" + fileText[k] + "\n");
                                                                        coordinates.add(fileText[k]);
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if(coordinates.size()>0) {
                                                            log("[commons] Znaleziono " + coordinates.size() + " zdjęć ze współrzędnymi\n");
                                                            /*
                                                            * Wyliczanie średniej
                                                            */
                                                            ArrayList<Float> N = new ArrayList<Float>();
                                                            ArrayList<Float> E = new ArrayList<Float>();


                                                            for(int j=0;j<coordinates.size();++j) {
                                                                String[] split = coordinates.get(j).split("[\\|(\\}\\})]");

                                                                /*
                                                                * format dziesiętny
                                                                */
                                                                if(split[0].toLowerCase().contains("location dec")) {
                                                                    N.add(Float.parseFloat(split[1]));
                                                                    E.add(Float.parseFloat(split[2]));
                                                                }
                                                                /*
                                                                * format DMS {{Location|49|9|28.96|N|22|33|5.16|E|region:PL}}
                                                                */
                                                                else if(split[0].toLowerCase().contains("location")) {
                                                                    N.add(Float.parseFloat(split[1]) + ((60*Float.parseFloat(split[2]) + Float.parseFloat(split[3]))/3600));
                                                                    E.add(Float.parseFloat(split[5]) + ((60*Float.parseFloat(split[6]) + Float.parseFloat(split[7]))/3600));
                                                                }
                                                            }

                                                            float N_ = 0;
                                                            float E_ = 0;

                                                            for(Float f : N) N_ += f;
                                                            N_ = N_/(float)N.size();
                                                            for(Float f : E) E_ += f;
                                                            E_ = E_/(float)E.size();
                                                            logGreen("[commons] Współrzędne: " + N_ + ";" + E_ + "\n");
                                                            ++toEdit;
                                                            try {
                                                                text[i].zapiszKoordynaty(N_, E_);
                                                            } catch (Exception ex) {
                                                                logRed("[błąd] Błąd: "+ex.getLocalizedMessage()+"\n");
                                                            }
                                                        }
                                                        else 
                                                            logRed("[commons] Brak współrzędnych\n");
                                                    } else 
                                                        log("[commons] Brak plików w kategorii\n");
                                                }
                                            } catch (IOException ex) {
                                                logRed("[commons] BŁĄD: spieprzony link do Commons!\n");
                                            }
                                        }
                                        /*
                                         * Koordynaty z pliku w tabelce
                                         */
                                        else if(text[i].jestZdjecie() && !text[i].jestKoordynaty()) {
                                            logBold("\n[info] #" + i + ": Szukanie w zdjęciu w tabelce (" + text[i].zwrocZdjecie().replace("_", " ").trim() + ")\n");
                                            String page = commons.getPageText("File:" + text[i].zwrocZdjecie());
                                            
                                            if(page.contains("ocation")) {
                                                page = page.replace("}}", "}}\n");
                                                float N_ = 0;
                                                float E_ = 0;
                                                String[] catText = page.split("\n");

                                                for(int k=0;k<catText.length;++k) {
                                                    if(catText[k].toLowerCase().contains("location") && !catText[k].toLowerCase().contains("=")) {
                                                        String[] split = catText[k].split("[\\|(\\}\\})]");
                                                        /*
                                                        * format dziesiętny
                                                        */
                                                        //log(">>>>>>>>>" + split[0] + "\n");
                                                        if(split[0].toLowerCase().contains("location dec")) {
                                                            N_ = Float.parseFloat(split[1]);
                                                            E_ = Float.parseFloat(split[2]);
                                                        }
                                                        /*
                                                        * format DMS {{Location|49|9|28.96|N|22|33|5.16|E|region:PL}}
                                                        */
                                                        else if(split[0].toLowerCase().contains("location")) {
                                                            N_ = Float.parseFloat(split[1]) + ((60*Float.parseFloat(split[2]) + Float.parseFloat(split[3]))/3600);
                                                            E_ = Float.parseFloat(split[5]) + ((60*Float.parseFloat(split[6]) + Float.parseFloat(split[7]))/3600);
                                                        }
                                                        break;
                                                    }
                                                }
                                                logGreen("[zdjęcie] Współrzędne: " + N_ + ";" + E_ + "\n");
                                                ++toEdit;
                                                try {
                                                    text[i].zapiszKoordynaty(N_, E_);
                                                } catch (Exception ex) {
                                                    logRed("[błąd] Błąd: "+ex.getLocalizedMessage()+"\n");
                                                }
                                            } else
                                                logRed("[zdjęcie] Brak współrzędnych\n");
                                        }
                                    }
                                    }
                                    
                                }
                                /*
                                 * Jest coś do zapisania
                                 */
                                if(stopRq)
                                    log("\n[info] Praca przerwana\n\n");
                                else {
                                    if(toEdit>0) {
                                        for(Wiersz w : text)
                                            output += w.zwrocWiersz();

                                        log("\n[info] Koniec pracy. Zapisać " + toEdit + " zmian?\n\n");
                                        bSave.setEnabled(true);
                                    } else
                                        log("\n[info] Koniec pracy. Nic do roboty\n\n");
                                        stopRq();
                                }
                            }
                        }
                    } catch (IOException ex) {
                        log("[błąd] Błąd: " + ex + "\n");
                        stopRq();
                    }
                }
            };
            Thread t = new Thread(run);
            t.start();
    }
    
    private void stopRq() {
        stopRq = true;
        bStart.setEnabled(true);
    }
    
    public void log(String s) {
        try {
            Document doc = loger.getDocument();
            doc.insertString(doc.getLength(), s, null);
        } catch(BadLocationException exc) {
        }
    }
    
    public void logBold(String s) {
        try {
            SimpleAttributeSet attributes = new SimpleAttributeSet();
            StyleConstants.setBold(attributes, true);
            Document doc = loger.getDocument();
            doc.insertString(doc.getLength(), s, attributes);
        } catch(BadLocationException exc) {
        }
    }
    
    public void logRed(String s) {
        try {
            SimpleAttributeSet attributes = new SimpleAttributeSet();
            StyleConstants.setForeground(attributes, Color.red);
            Document doc = loger.getDocument();
            doc.insertString(doc.getLength(), s, attributes);
        } catch(BadLocationException exc) {
        }
    }
    
    public void logGreen(String s) {
        try {
            SimpleAttributeSet attributes = new SimpleAttributeSet();
            StyleConstants.setForeground(attributes, new Color(0, 102, 0));
            Document doc = loger.getDocument();
            doc.insertString(doc.getLength(), s, attributes);
        } catch(BadLocationException exc) {
        }
    }
    
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        final JFrame frame = new Main();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bOpen;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bStart;
    private javax.swing.JButton bStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextPane loger;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField tLogin;
    private javax.swing.JTextField tPage;
    private javax.swing.JPasswordField tPass;
    // End of variables declaration//GEN-END:variables
}
