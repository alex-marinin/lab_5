/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.matveev.lab3;
import java.io.*;
import java.util.*;

 interface Movable {
    
    void move(int x, int y); // перемещение в точку (x,)
    
}  
 interface Mirrorable {
    
   void mirrorOfX(); // симметрия относительно Ох
   void mirrorOfY(); // симметрия относительно Ох
    
}
class Figure implements Comparable <Figure>, Movable,Mirrorable {
        public int id;
        public String name;
        public int x,y;
        public String square;
        public String perimetr;
        public int SortType = 0;
        Figure(){}
        Figure(int id1, int x1, int y1, String name1, String square1, String perimetr1)
        {
            x=x1;
            y=y1;
            x=x1; y=y1; name = name1; id = id1; square = square1; perimetr = perimetr1;
        }
        void print(){System.out.printf("id-%-3s x:%-3s y:%-3s Фигура: %-15s Площадь: %-2s Периметр: %-4s\n",Integer.toString(id),Integer.toString(x),Integer.toString(y),name,square,perimetr);}

    
    public int compareTo(Figure t) {
      int res = 0;
      Figure other = (Figure) t;
      if (SortType == 1) //по айди
      { if (id > other.id) res = 1;
        if (id < other.id) res = -1;
      }
      if (SortType == 2) //по периметру
      {   res = perimetr.compareTo(other.perimetr);}
      if (SortType == 3) //по фамилии
      {   res = name.compareTo(other.name);}
      return res; 
    }

    @Override
    public void move(int x1, int y1) {
      x = x1;
      y = y1;
    }

    @Override
    public void mirrorOfX() {
        y = y*(-1);
    }

    @Override
    public void mirrorOfY() {
       x = x*(-1);
    }


       
    }
    class Triangle extends Figure {
        public String type_tr;
        public String father;
        Triangle(int id1, int x1, int y1, String name1, String square1, String perimetr1, String mo)
        {
            id = id1; x=x1; y=y1; name = name1; square = square1; perimetr = perimetr1; type_tr = mo;
        }
        void print(){System.out.printf("id-%-3s x:%-3s y:%-3s Фигура: %-15s Площадь: %-2s Периметр: %-4s Тип треугольника: %s\n",Integer.toString(id),Integer.toString(x),Integer.toString(y),name,square,perimetr,type_tr);}        
    }
    class Quadrangle extends Figure {
        public String type_qu;
        Quadrangle(int id1, int x1, int y1, String name1, String square1, String perimetr1, String uni)
        {id = id1; x=x1; y=y1; name = name1; square = square1; perimetr = perimetr1; type_qu = uni;}
        void print(){System.out.printf("id-%-3s x:%-3s y:%-3s Фигура: %-15s Площадь: %-2s Периметр: %-4s Тип четырехугольника: %s\n",Integer.toString(id),Integer.toString(x),Integer.toString(y),name,square,perimetr,type_qu);}        
    }
    class Hexagon extends Figure {
        public String type_hex;
        Hexagon(int id1, int x1, int y1, String name1, String square1, String perimetr1, String de)
        {id = id1; x=x1; y=y1; name = name1; square = square1; perimetr = perimetr1; type_hex = de;}
        void print(){System.out.printf("id-%-3s x:%-3s y:%-3s Фигура: %-15s Площадь: %-2s Периметр: %-4s Тип пятиугольника: %s\n",Integer.toString(id),Integer.toString(x),Integer.toString(y),name,square,perimetr,type_hex);}        
    }
    class Pentagon extends Figure {
        public String type_pen;
        Pentagon(int id1, int x1, int y1, String name1, String square1, String perimetr1, String spe)
        {id = id1; x=x1; y=y1; name = name1; square = square1; perimetr = perimetr1; type_pen = spe;}
        void print(){System.out.printf("id-%-3s x:%-3s y:%-3s Фигура: %-15s Площадь: %-2s Периметр: %-4s Тип шестиугольника: %s\n",Integer.toString(id),Integer.toString(x),Integer.toString(y),name,square,perimetr,type_pen);}        
    }

public class Lab3 {
    public static int key = -1;
    public static Figure test = new Figure();
    public static List<Figure> baze = new ArrayList();
    
    public static void main(String[] args) throws IOException {
      
        
        while(key!=0)
        {
            System.out.println("1 - Создать простую фигуру");
            System.out.println("2 - Создать треугольник");
            System.out.println("3 - Создать четырехугольник");
            System.out.println("4 - Создать пятиугольник");
            System.out.println("5 - Создать шестиугольник");
            System.out.println("6 - Вывод списка с детальной информацией");
            System.out.println("7 - Удаление по id");
            System.out.println("8 - Сортировка по id");
            System.out.println("9 - Сортировка по периметру");
            System.out.println("10- Сортировка по фигуре");
            System.out.println("11- Переместить фигуру в точку");
            System.out.println("12- Отразить относительно Ох");
            System.out.println("13- Отразить относительно Оу");
            
            System.out.println("0 - Выход");
            InputStreamReader isr = new InputStreamReader(System.in); 
            BufferedReader br = new BufferedReader(isr); 

            Scanner in = new Scanner(System.in);
            key = in.nextInt();
            switch(key)
            {
                case 1:
                    System.out.println("Введите id: ");
                    int id = in.nextInt();
                    System.out.println("Введите x: ");
                    int x = in.nextInt();
                    System.out.println("Введите y: ");
                    int y = in.nextInt();
                    
                    System.out.println("Введите фигуру: ");
                    String name = in.next();
                    System.out.println("Введите периметр: ");
                    String perimetr = br.readLine();
                    System.out.println("Введите площадь: ");
                    String square = br.readLine();
                    System.out.println("На какое место добавить?(всего-"+baze.size()+",добавить на любое - 0)");
                    int pos = in.nextInt();
                    pos = pos -1;
                    if(baze.size()!=0 && pos != -1) 
                         {baze.add(pos,new Figure(id,x,y,name,square,perimetr));}
                    else {baze.add(new Figure(id,x,y,name,square,perimetr));}
                    
                    break;
                case 3:
                    System.out.println("Введите id: ");
                    id = in.nextInt();
                    System.out.println("Введите x: ");
                    x = in.nextInt();
                    System.out.println("Введите y: ");
                    y = in.nextInt();
                    name = "Четырехугольник";
                    System.out.println("Введите периметр: ");
                    perimetr = br.readLine();
                    System.out.println("Введите площадь: ");
                    square = br.readLine();
                    System.out.println("Введите вид четырехугольника: ");
                    String univ = br.readLine();
                    System.out.println("На какое место добавить?(всего-"+baze.size()+",добавить на любое - 0)");
                    pos = in.nextInt();
                    pos = pos -1;
                    if(baze.size()!=0 && pos != -1) 
                         {baze.add(pos,new Quadrangle(id,x,y,name,square,perimetr,univ));}
                    else {baze.add(new Quadrangle(id,x,y,name,square,perimetr,univ));}
                    
                
                    break;
                case 4:
                    System.out.println("Введите id: ");
                    id = in.nextInt();
                    name = "Пятиугольник";
                    System.out.println("Введите x: ");
                    x = in.nextInt();
                    System.out.println("Введите y: ");
                    y = in.nextInt();
                    System.out.println("Введите периметр: ");
                    perimetr = br.readLine();
                    System.out.println("Введите площадь: ");
                    square = br.readLine();
                    System.out.println("Введите тип пятиугольника: ");
                    String type_pen = br.readLine();
                    System.out.println("На какое место добавить?(всего-"+baze.size()+",добавить на любое - 0)");
                    pos = in.nextInt();
                    pos = pos -1;
                    if(baze.size()!=0 && pos != -1) 
                         {baze.add(pos,new Pentagon(id,x,y,name,square,perimetr,type_pen));}
                    else {baze.add(new Pentagon(id,x,y,name,square,perimetr,type_pen));}

                   
                    break;                
                case 2:
                    System.out.println("Введите id: ");
                    id = in.nextInt();
                    name = "Треугольник";
                    System.out.println("Введите x: ");
                    x = in.nextInt();
                    System.out.println("Введите y: ");
                    y = in.nextInt();
                    System.out.println("Введите периметр: ");
                    perimetr = br.readLine();
                    System.out.println("Введите площадь: ");
                    square = br.readLine();
                    System.out.println("Введите тип треугольника: ");
                    String type_tr = br.readLine();
                    System.out.println("На какое место добавить?(всего-"+baze.size()+",добавить на любое - 0)");
                    pos = in.nextInt();
                    pos = pos -1;
                    if(baze.size()!=0 && pos != -1) 
                         {baze.add(pos,new Triangle(id,x,y,name,square,perimetr,type_tr));}
                    else {baze.add(new Triangle(id,x,y,name,square,perimetr,type_tr));}
                    
                    break;
               case 5:
                    System.out.println("Введите id: ");
                    id = in.nextInt();
                    name = "Шестиугольник";br.readLine();
                    System.out.println("Введите x: ");
                    x = in.nextInt();
                    System.out.println("Введите y: ");
                    y = in.nextInt();
                    System.out.println("Введите периметр: ");
                    perimetr = br.readLine();
                    System.out.println("Введите площадь: ");
                    square = br.readLine();
                    System.out.println("Введите тип шестиугольника: ");
                    String thex = br.readLine();
                    System.out.println("На какое место добавить?(всего-"+baze.size()+",добавить на любое - 0)");
                    pos = in.nextInt();
                    pos = pos -1;
                    if(baze.size()!=0 && pos != -1) 
                         {baze.add(pos,new Hexagon(id,x,y,name,square,perimetr,thex));}
                    else {baze.add(new Hexagon(id,x,y,name,square,perimetr,thex));}
                    
                    break;
               case 6:
                   
                   //Iterator it = baze.iterator();
                  // int k = 1;
                   for(Figure test: baze)
                  {
                      test.print();
                  }
                  /* while (it.hasNext())
                   {
                       test = (Figure) it.next();
                       System.out.print(k+": ");
                       test.print();
                       k++;
                   }*/
                   
                   break;
              case 7:
                  System.out.print("Введите id: ");
                  int id1 = in.nextInt();
                  for(int i = 0; i < baze.size(); i++)
                  {
                   test = (Figure) baze.get(i);
                   if (test.id == id1) 
                   {
                        baze.remove(i);
                        System.out.println("Удаление произведено!"); 
                        i = baze.size();
                   }
                  }
                  break;
              case 8:
                  
                 for(int i = 0; i < baze.size(); i++)
                  {
                   test = (Figure)baze.get(i);
                   test.SortType = 1;
                   baze.set(i,test);
                  }
                  Collections.sort(baze);
                  break;
              case 9:
                  for(int i = 0; i < baze.size(); i++)
                  {
                   test = (Figure)baze.get(i);
                   test.SortType = 2;
                   baze.set(i,test);
                  }
                  Collections.sort(baze);
                  break;
              case 10:
                  for(int i = 0; i < baze.size(); i++)
                  {
                   test = (Figure)baze.get(i);
                   test.SortType = 3;
                   baze.set(i,test);
                  }
                  Collections.sort(baze);
                  break;
              case 11:
                  System.out.print("Введите id: ");
                  id1 = in.nextInt();
                  for(int i = 0; i < baze.size(); i++)
                  {
                   test = (Figure) baze.get(i);
                   if (test.id == id1) 
                   {
                       System.out.println("Введите х,у: "); 
                       int xx = in.nextInt();
                       int yy = in.nextInt();
                       test.move(xx, yy);
                       baze.set(i,test);
                        System.out.println("Перемещение произведено!"); 
                        
                   }
                  }
                  break;
              case 12:
                  System.out.print("Введите id: ");
                  id1 = in.nextInt();
                  for(int i = 0; i < baze.size(); i++)
                  {
                   test = (Figure) baze.get(i);
                   if (test.id == id1) 
                   {
                       
                       test.mirrorOfX();
                       baze.set(i,test);
                        System.out.println("Отражение произведено!"); 
                        
                   }
                  }
                  break;
              case 13:
                  System.out.print("Введите id: ");
                  id1 = in.nextInt();
                  for(int i = 0; i < baze.size(); i++)
                  {
                   test = (Figure) baze.get(i);
                   if (test.id == id1) 
                   {
                       
                       test.mirrorOfY();
                       baze.set(i,test);
                        System.out.println("Отражение произведено!"); 
                        
                   }
                  }
                  break;
                  
            }
        }
    }
}

