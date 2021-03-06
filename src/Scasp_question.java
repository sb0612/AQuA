//package scasp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

import javafx.util.Pair;

public class Scasp_question {


    //public static String content = "What does AC stand for?";
    public static void TestSetupParser() {
        Sentence.SetupLexicalizedParser();
    }


    public static void InitializeTest() {
        Word.eventId = 1;
    }

    public static void PrintRules(TreeSet<String> ruleString) {
        for (String rule : ruleString) {
          //  System.out.println(String.format("%s.", rule));
        }
    }

    public static void printQuestion(String content, BufferedWriter bw) throws IOException {

        //TestSetupParser();
        //InitializeTest();
        //String content = "Since what year did ABC stylize abc's logo, as abc ?";
        Question question = new Question(content);
        List<Rule> rules = ClevrQueryGeneration.getClevrQuery(filteredCorrectedParsing(question));
        //System.out.println(Sentence.DependenciesToString(question));
        //----------------------------------------------------------------------------------------------------
        /*if (question.information.questionType == QuestionType.WHO && question.semanticRoot.getPOSTag().equals("NN")){
            String keyWord = question.semanticRoot.getWord();
            String resp = HttpRequest.getKnowledge(keyWord);
        }*/

        //----------------------------------------------------------------------------------------------------
      //  List<Rule> rules = question.GenerateAllRules();
        //LiteralType type = LiteralType.FACT;
        //System.out.println("/*----------------  " + type.toString() + "  ------------------*/");
//        for (Rule rule : rules) {
//            if (type != rule.maxRuleQuality) {
//                type = rule.maxRuleQuality;
//                //System.out.println("/*----------------  " + type.toString() + "  ------------------*/");
//            }
//            //System.out.println(String.format("Assert.assertTrue(ruleString.contains(\"%s\"));", rule.toString()));
//        }

        //System.out.print("\n\n");
        //List<String> ruleString = new ArrayList<>();
        //String sentence = question.sentenceString.replaceAll("'", "");
        //bw.write(String.format("question('%s', 1).", sentence));
        //bw.newLine();
        for (Rule rule : rules) {
            //System.out.println(String.format("%s.", rule.toString()));
            //ruleString.add(rule.toString());
            bw.write(String.format("%s.", rule.toString()));
            bw.newLine();
        }
    }


    //TODO POS Correction
    private static Question filteredCorrectedParsing(Question question) {
        //POS correction
        question.wordList.stream().forEach(w -> {
            if(w.getLemma().equalsIgnoreCase("metal") && w.getPOSTag().equalsIgnoreCase("nn")){
                w.setPOSTag("JJ");
            }
            else if(w.getLemma().equalsIgnoreCase("rubber") && w.getPOSTag().equalsIgnoreCase("nn")){
                w.setPOSTag("JJ");
            }
            else if(w.getLemma().equalsIgnoreCase("matte") && w.getPOSTag().equalsIgnoreCase("nn")){
                w.setPOSTag("JJ");
            }
            else if(w.getLemma().equalsIgnoreCase("cyan") && w.getPOSTag().equalsIgnoreCase("nn")){
                w.setPOSTag("JJ");
            }
            else if(w.getLemma().equalsIgnoreCase("yellow") && w.getPOSTag().equalsIgnoreCase("nn")){
                w.setPOSTag("JJ");
            }
            else if(w.getWord().equalsIgnoreCase("left") && w.getPOSTag().equalsIgnoreCase("vbn")){
                w.setPOSTag("JJ");
                w.setLemma("left");
            }
            else if(w.getWord().equalsIgnoreCase("left") && w.getPOSTag().equalsIgnoreCase("vbd")){
                w.setPOSTag("JJ");
                w.setLemma("left");
            }
            else if(w.getLemma().equalsIgnoreCase("block") && w.getPOSTag().equalsIgnoreCase("vb")){
                w.setPOSTag("NN");
            }
            else if(w.getLemma().equalsIgnoreCase("block") && w.getPOSTag().equalsIgnoreCase("vbz")){
                w.setPOSTag("NN");
            }
            else if(w.getLemma().equalsIgnoreCase("red") && w.getPOSTag().equalsIgnoreCase("nn")){
                w.setPOSTag("JJ");
            }
            else if(w.getLemma().equalsIgnoreCase("blue") && w.getPOSTag().equalsIgnoreCase("nn")){
                w.setPOSTag("JJ");
            }
        });

        return question;

    }
}
