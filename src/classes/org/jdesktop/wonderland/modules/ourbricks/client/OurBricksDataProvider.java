package org.jdesktop.wonderland.modules.ourbricks.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBricksGateway;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBricksList;

public class OurBricksDataProvider {
    public static final int SEARCH_LIMIT = 8;

    private final OurBricksGateway gate;

    public OurBricksDataProvider(OurBricksGateway gateway){

        this.gate = gateway;
    }
    
    protected OurBricksList requestDataFromExternalService(String query, Integer next) throws MalformedURLException, IOException {
        
        OurBricksList bricksList;
        URL searchURL;
        if ( query == null && next == null ){
            searchURL = new URL("http://ourbricks.com/api/search?limit=" + SEARCH_LIMIT);
        } else if ( query == null && next != null ){
            searchURL = new URL("http://ourbricks.com/api/search?&start=" + next + "&limit=" + SEARCH_LIMIT);
        } else if ( query != null && next == null ){
            searchURL = new URL("http://ourbricks.com/api/search?q=" + query + "&limit=" + SEARCH_LIMIT);
        } else {
            searchURL = new URL("http://ourbricks.com/api/search?q=" + query + "&start=" + next + "&limit=" + SEARCH_LIMIT);
        } 

        System.out.println("Search URL is: " + searchURL);
        bricksList = gate.getBricksList(searchURL);

        return bricksList;
    }

    //TODO Leaving these comments for this partial commit -- Fix the import situation before pushing to remote
//    public File fileToImport(String fileURL, String modelName, OurBricksJPanel panel) throws MalformedURLException, IOException {
    public void fileToImport(String fileURL, String modelName, OurBricksJPanel panel) throws MalformedURLException, IOException {

//        File brickZipFile = requestFileFromExternalService(fileURL, modelName, panel);
        requestFileFromExternalService(fileURL, modelName, panel);
        String folderToUnzip = System.getProperty("java.io.tmpdir")
                + System.getProperty("file.separator") + modelName
                + System.getProperty("file.separator") + modelName + "_unzipped";

        //TODO ADD BACK THESE TWO STEPS WHEN I HAVE A CHANCE OF GETTING BACK THE NAME OF THE FILE
        // DO I need two buttons: download + import ?
//        File unzippedFile = unzipBrickFile(brickZipFile, folderToUnzip);
//
//        return findDaeFile(unzippedFile);
    }
    
    private void requestFileFromExternalService(String fileURL, String modelName, OurBricksJPanel panel) throws MalformedURLException, IOException {

        gate.getBrickFile(new URL(fileURL), modelName, panel);
    }

    //TODO this is not responsibily of the provider <-- move it!
    public static File unzipBrickFile(File brickZipFile, String destination) throws IOException {
        File destinationFile = new File(destination);
        destinationFile.mkdirs();

        // unzip fileToUnzip into destination
        final int BUFFER = 2048;
        BufferedOutputStream dest = null;
        FileInputStream streamToZipFile = new FileInputStream(brickZipFile);
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(streamToZipFile));
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            if (entry.isDirectory()) {
                File dir = new File(destination + File.separator + entry.getName());
                dir.mkdirs();
                continue;
            }

            int count;
            byte data[] = new byte[BUFFER];
            // write the files to disk
            FileOutputStream fos = new FileOutputStream(destination + File.separator + entry.getName());
            dest = new BufferedOutputStream(fos, BUFFER);
            while ((count = zis.read(data, 0, BUFFER)) != -1) {
                dest.write(data, 0, count);
            }
            dest.flush();
            dest.close();
        }
        zis.close();

        return destinationFile;
    }

    /**
     * Found .dae files in a location provided as input
     * @param unzippedFile The location of the unzipped directory
     * @return the dae file found of Null in case of not finding any
     */
    public static File findDaeFile(File unzippedFile) {
        //TODO DRY this code
        File [] files = unzippedFile.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(".dae");
            }
        });

        if (files.length > 0)
            return files[0];

        //Check for dae files in any subdirectories
        files = unzippedFile.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });

        if (files.length > 0){
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                File [] dirFiles = file.listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        return file.getName().endsWith(".dae");
                    }
                });

                if (dirFiles.length > 0){
                    return dirFiles[0];
                }
            }
        }

        return null;
    }
}
