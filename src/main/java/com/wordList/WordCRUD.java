package com.wordList;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class WordCRUD implements ICRUD{
    private int count;
    Word w;
    ArrayList<Word> list;
    Scanner s = new Scanner(System.in);

    public WordCRUD() {
        list = new ArrayList<>();
    }

    public void setCount(){
        this.count++;
    }
    public int getCount(){
        return this.count;
    }

    public int selectMenu(){
        System.out.print("*** 영단어 마스터 ***\n"
                +"*********************\n"
                +"1. 모든 단어 보기\n"
                +"2. 수준별 단어 보기\n"
                +"3. 단어 검색\n"
                +"4. 단어 추가\n"
                +"5. 단어 수정\n"
                +"6. 단어 삭제\n"
                +"7. 파일 저장\n"
                +"0. 나가기\n"
                +"********************\n"
                +"=> 원하는 메뉴는? ");

        return s.nextInt();
    }

    public int addWord() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int l_num = s.nextInt();
        String word = s.next();

        System.out.print("뜻 입력 : ");
        String mean = s.next();

        System.out.println();

        w = new Word(l_num,word,mean);
        count++;
        list.add(w);
        return 1;

    }

    public void read() {
        System.out.println("--------------------------------");
        for(int i = 0; i < list.size(); i++){
            System.out.println((i+1) +" " + list.get(i).toString());
        }
        System.out.println("--------------------------------");
        System.out.println();
    }
    public int deleteWord() {
        int check = selectOne();
        int final_check = 0;

        System.out.print("정말로 삭제하시겠습니까?(삭제 : 1) ");
        final_check = s.nextInt();
        count --;

        if(final_check == 1){
            list.remove(check-1);
            return 1;
        }
        else{
            return 0;
        }
    }

    public int updateWord() {
        int check = selectOne();

        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int l_num = s.nextInt();
        String word = s.next();

        System.out.print("뜻 입력 : ");
        String mean = s.next();

        w = new Word(l_num, word, mean);
        this.list.set((check-1),w);

        return 1;
    }
    public int selectOne(){
        System.out.print("선택할 번호는? ");
        int number = s.nextInt();
        return number;
    }

    public int loadFile(){
        String file_name = "Dictionary.txt";
        String word;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file_name));

            while(true){
                word = reader.readLine();
                if(word == null){
                    break;
                }
                String data[] = word.split("\\|");
                int w_level = Integer.parseInt(data[0]);
                String w_word = data[1];
                String w_mean = data[2];
                Word w = new Word(w_level,w_word, w_mean);
                count++;
                list.add(w);
            }
            reader.close();

        } catch(IOException e){
            e.printStackTrace();
            return 0;

        }
        return 1;
    }
    public int saveFile(){
        String file_name = "Dictionary.txt";
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file_name));

            for(Word wordList : list){
                int w_level = wordList.getLevel();
                String w_word = wordList.getWord();
                String w_mean = wordList.getMeaning();
                writer.write(w_level+"|"+w_word+"|"+w_mean + "\n");
            }
            writer.close();

            return 1;
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
    }

}
