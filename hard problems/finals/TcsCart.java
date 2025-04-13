import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TcsCart {

 
    public static double crossProd(double[] p, double[] a, double[] b) {
        return (a[0] - p[0]) * (b[1] - p[1]) - (a[1] - p[1]) * (b[0] - p[0]);
    }

    public static List<double[]> convexPoly(List<double[]> points) {
        Collections.sort(points, (a, b) -> Double.compare(a[0], b[0]));
        List<double[]> lower = new ArrayList<>();
        List<double[]> upper = new ArrayList<>();

        for (double[] p : points) {
            while (lower.size() >= 2 && crossProd(lower.get(lower.size() - 2), lower.get(lower.size() - 1), p) <= 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(p);
        }

        for (int i = points.size() - 1; i >= 0; i--) {
            double[] p = points.get(i);
            while (upper.size() >= 2 && crossProd(upper.get(upper.size() - 2), upper.get(upper.size() - 1), p) <= 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(p);
        }

        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);

        List<double[]> hull = new ArrayList<>(lower);
        hull.addAll(upper);

        return hull;
    }

    public static int[] boundingBoxArea(List<double[]> poly) {
        double minArea = Double.MAX_VALUE;
        int[] minDms = new int[2];

        int n = poly.size();
        for (int i = 0; i < n; i++) {
            double[] p1 = poly.get(i);
            double[] p2 = poly.get((i + 1) % n);

            double edgeDx = p2[0] - p1[0];
            double edgeDy = p2[1] - p1[1];
            double edgeLength = Math.sqrt(edgeDx * edgeDx + edgeDy * edgeDy);

            double ux = edgeDx / edgeLength;
            double uy = edgeDy / edgeLength;
            double px = -uy;
            double py = ux;

            double minProjEdge = Double.MAX_VALUE;
            double maxProjEdge = Double.MIN_VALUE;
            double minProjPerp = Double.MAX_VALUE;
            double maxProjPerp = Double.MIN_VALUE;

            for (double[] point : poly) {
                double projEdge = ux * (point[0] - p1[0]) + uy * (point[1] - p1[1]);
                double projPerp = px * (point[0] - p1[0]) + py * (point[1] - p1[1]);

                minProjEdge = Math.min(minProjEdge, projEdge);
                maxProjEdge = Math.max(maxProjEdge, projEdge);
                minProjPerp = Math.min(minProjPerp, projPerp);
                maxProjPerp = Math.max(maxProjPerp, projPerp);
            }

            double width = maxProjEdge - minProjEdge;
            double height = maxProjPerp - minProjPerp;
            double area = width * height;

            if (area < minArea) {
                minArea = area;
                minDms[0] = (int) Math.ceil(width);
                minDms[1] = (int) Math.ceil(height);
            }
        }

        Arrays.sort(minDms);
        return minDms;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<double[]> vertices = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            vertices.add(new double[] {x, y});
        }

        List<double[]> poly = convexPoly(vertices);

 
        int[] dms = boundingBoxArea(poly);

        System.out.println(dms[0] + " " + dms[1]);

        sc.close();
    }
}
