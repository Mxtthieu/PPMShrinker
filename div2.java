import java.io.*;

public class div2 {
    public static void main(String[] args){
        String file = "src/arbreASCII.ppm";
        File out = new File("src/arbreDiv2.ppm");
        BufferedReader br;
        String tmp;
        try
        {
            br = new BufferedReader(new FileReader(file));
            FileReader in = new FileReader(file);
            FileWriter outw = new FileWriter(out);
            tmp = br.readLine();
            outw.write(tmp);
            outw.write(System.getProperty("line.separator"));
            tmp = br.readLine();
            outw.write(tmp);
            outw.write(System.getProperty("line.separator"));
            String taille = br.readLine();
            String[] parts = taille.split(" ");
            String w = parts[0];
            outw.write(String.valueOf(Integer.parseInt(w)/2));
            outw.write(" ");
            String h = parts[1];
            outw.write(String.valueOf(Integer.parseInt(h)/2));
            outw.write(System.getProperty("line.separator"));
            String max = br.readLine();
            outw.write(max);
            outw.write(System.getProperty("line.separator"));
            int read[][][] = new int[Integer.parseInt(w)][Integer.parseInt(h)][3];
            for(int i=0; i<Integer.parseInt(h); i++){
                for(int j=0; j<Integer.parseInt(w); j++) {
                    read[j][i][0] = Integer.parseInt(br.readLine());
                    read[j][i][1] = Integer.parseInt(br.readLine());
                    read[j][i][2] = Integer.parseInt(br.readLine());
                }
            }
            int meanR;
            int meanG;
            int meanB;
            for(int y=0; y<Integer.parseInt(h); y+=2){
                for(int x=0; x<Integer.parseInt(w); x+=2){
                    meanR = (read[x][y][0] + read[x+1][y][0] + read[x][y+1][0] + read[x+1][y+1][0]) / 4;
                    meanG = (read[x][y][1] + read[x+1][y][1] + read[x][y+1][1] + read[x+1][y+1][1]) / 4;
                    meanB = (read[x][y][2] + read[x+1][y][2] + read[x][y+1][2] + read[x+1][y+1][2]) / 4;
                    outw.write(String.valueOf(meanR));
                    outw.write(System.getProperty("line.separator"));
                    outw.write(String.valueOf(meanG));
                    outw.write(System.getProperty("line.separator"));
                    outw.write(String.valueOf(meanB));
                    outw.write(System.getProperty("line.separator"));
                }
            }
            in.close();
            outw.close();
        }
        catch(FileNotFoundException exc) { System.out.println("Erreur d'ouverture"); }
        catch (IOException ex) { System.err.println(ex); }
    }
}
