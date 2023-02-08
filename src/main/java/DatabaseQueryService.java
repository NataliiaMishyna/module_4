import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("findMaxProjectsClient().toString() = " + findMaxProjectsClient());
        System.out.println("findLongestProject() = " + findLongestProject());
        System.out.println("findMaxSalaryWorker() = " + findMaxSalaryWorker());
        System.out.println("findYoungestOldestWorkers() = " + findYoungestOldestWorkers());
        System.out.println("printProjectPrices() = " + printProjectPrices());
    }

    private static List<MaxProjectCountClient> findMaxProjectsClient() throws IOException, SQLException {
        String sql = String.join("\n",
                Files.readAllLines(Paths.get("sql/find_max_projects_client.sql")));
        Connection conn = Database.getConnection();
        Statement st = conn.createStatement();
        ResultSet resultSet = st.executeQuery(sql);
        List<MaxProjectCountClient> maxProjectCountClient = new ArrayList<>();
        while(resultSet.next()){
            MaxProjectCountClient maxPC = new MaxProjectCountClient();
            maxPC.setName(new String(resultSet.getBytes(1),"windows-1251"));
            maxPC.setProjectCount(resultSet.getInt(2));
            maxProjectCountClient.add(maxPC);
        }
        st.close();
        return maxProjectCountClient;
    }

    private static List<LongestProject> findLongestProject() throws IOException, SQLException {
        String sql = String.join("\n",
                Files.readAllLines(Paths.get("sql/find_longest_project.sql")));//,StandardCharsets.UTF_16));
        Connection conn = Database.getConnection();
        Statement st = conn.createStatement();
        ResultSet resultSet = st.executeQuery(sql);
        List<LongestProject> longestProjects = new ArrayList<>();
        while(resultSet.next()){
            LongestProject lProject = new LongestProject();
            lProject.setMonthCount(resultSet.getString(1));
            longestProjects.add(lProject);
        }
        st.close();
        return longestProjects;
    }

    private static List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException, SQLException {
        String sql = String.join("\n",
                Files.readAllLines(Paths.get("sql/find_max_salary_worker.sql")));//,StandardCharsets.UTF_16));
        Connection conn = Database.getConnection();
        Statement st = conn.createStatement();
        ResultSet resultSet = st.executeQuery(sql);
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        while(resultSet.next()){
            MaxSalaryWorker max = new MaxSalaryWorker();
            max.setName(new String(resultSet.getBytes(1),"windows-1251"));
            max.setMaxSalaryworker(resultSet.getInt(2));
            maxSalaryWorkers.add(max);
        }
        st.close();
        return maxSalaryWorkers;
    }

    private static List<YoungestOldestWorkers> findYoungestOldestWorkers() throws IOException, SQLException {
        String sql = String.join("\n",
                Files.readAllLines(Paths.get("sql/find_youngest_eldest_workers.sql")));//,StandardCharsets.UTF_16));
        Connection conn = Database.getConnection();
        Statement st = conn.createStatement();
        ResultSet resultSet = st.executeQuery(sql);
        List<YoungestOldestWorkers> youngestOldestWorkers = new ArrayList<>();
        while(resultSet.next()){
            YoungestOldestWorkers workers = new YoungestOldestWorkers();
            workers.setType(resultSet.getString(1));
            workers.setName(new String(resultSet.getBytes(2),"windows-1251"));
            workers.setBirthday(resultSet.getString(3));
            youngestOldestWorkers.add(workers);
        }
        st.close();
        return youngestOldestWorkers;
    }

    private static List<PrintProjectPrices> printProjectPrices() throws IOException, SQLException {
        String sql = String.join("\n",
                Files.readAllLines(Paths.get("sql/print_project_prices.sql")));//,StandardCharsets.UTF_16));
        Connection conn = Database.getConnection();
        Statement st = conn.createStatement();
        ResultSet resultSet = st.executeQuery(sql);
        List<PrintProjectPrices> printProjectPrices = new ArrayList<>();
        while(resultSet.next()){
            PrintProjectPrices price = new PrintProjectPrices();
            price.setProject(resultSet.getString(1));
            price.setPrice(resultSet.getInt(2));
            printProjectPrices.add(price);
        }
        st.close();
        return printProjectPrices;
    }

}

