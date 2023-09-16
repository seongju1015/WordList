package com.word;

public class WordManager {
    WordCRUD w = new WordCRUD();
    Word word;
    public void start(){
        int count = 0;
        int menu = 0;

        while(true){
            menu = w.selectMenu();
            if(menu == 0){
                break;
            }
            if(menu == 1 || menu == 2 || menu == 3 || menu == 5 || menu == 6 ||menu == 7){
                if(w.getCount() == 0) {
                    continue;
                }
            }
            if(menu == 1){
                w.read();
            }
            else if(menu == 4){
                if(w.addWord() == 1){
                    System.out.println("새 단어가 단어장에 추가되었습니다 !!!");
                    count++;
                }
                else{
                    continue;
                }
            }
            else if(menu == 5){
                if(w.updateWord() == 1){
                    System.out.println("수정되었습니다.");
                }
                else{
                    continue;
                }
            }
            else if(menu == 6){
                if(w.deleteWord() == 1){
                    System.out.println("삭제되었습니다. ");
                }
                else{
                    System.out.println("취소되었습니다. ");
                    continue;
                }
            }
            else{
                break;
            }
        }
        System.out.println("프로그램 종료! 다음에 만나요~");
    }

}
