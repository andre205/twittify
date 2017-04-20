public class main{

  public static void main(String[] args)
  {
      spotify_chart_fetcher s = new spotify_chart_fetcher();
      String[] t = s.getTop200();
      for (int i = 0; i < 200; ++i)
      {
          System.out.println(t[i]);
      }
  }
}
