
./sms_retriever_hash_v9.sh --package "configure.test.configurebuilds.miscellaneous" --keystore debug.keystore

debug key
keytool -exportcert -alias androiddebugkey -keystore  debug.keystore -storepass android -keypass android | xxd -p | tr -d "[:space:]" | echo -n configure.test.configurebuilds.miscellaneous `cat` | sha256sum | tr -d "[:space:]-" | xxd -r -p | base64 | cut -c1-11


