# OnActivityResult-invoke

[![Circle CI](https://circleci.com/gh/eaglesakura/onactivityresult-invoke.png?style=badge)](https://circleci.com/gh/eaglesakura/onactivityresult-invoke)

## 概要

AndroidのActivity.onActivityResultとFragment.onActivityResultの処理を自動化するためのライブラリです。

Android Annotations風のAnnotation(@OnActivityResult)をメソッドに付与することで、自動的にメソッドの呼び出しを行います。Android Annotationsと違い、Refrectionを使用したランタイム処理を行うので、余計なクラス生成やビルド時間の長大化を引き起こさずに済みます。

他のライブラリの依存なしに使用できます。

ActivityやFragmentだけでなく、その他のクラスでもアノテーションを付与するだけで同様に使用できます。

## LICENSE

プロジェクトの都合に応じて、下記のどちらかを選択してください。

* アプリ等の成果物で権利情報を表示可能な場合
	* 権利情報の表示を行う（行える）場合、MIT Licenseを使用してください。
	* [MIT License](LICENSE-MIT.txt)
* 何らかの理由で権利情報を表示不可能な場合
	* 何らかの事情によりライセンス表記を行えない場合、下記のライセンスで使用可能です。
	* ライブラリ内で依存している別なライブラリについては、必ずそのライブラリのライセンスに従ってください。
	* [NYSL(English)](LICENSE-NYSL-eng.txt)
	* [NYSL(日本語)](LICENSE-NYSL-jpn.txt)

## 使用例

### build.gradle

 1. repositoriesブロックにリポジトリURLを追加する
 1. dependenciesブロックに任意バージョンのライブラリを追加する
 	* 現時点では1.0.+系列

<pre>
repositories {
    maven { url "http://eaglesakura.github.io/maven/" }		// add maven repo
    mavenCentral()
}

dependencies {
    compile 'com.eaglesakura:onactivityresult-invoke:1.0.+'	// add library
}


</pre>

### onActivityResultの処理

 1. 戻り値なし、引数(int, Intent)のメソッドを作成する
 1. @OnActivityResult アノテーションをつける
 1. アノテーション引数に、任意のRequest Codeを付与する
 1. onActivityResultメソッドでActivityResult.invokeを呼び出す

<pre>
public class MainActivity extends AppCompatActivity {
    static final int REQUEST_REQUEST_PICK1 = 0x0001;
    static final int REQUEST_REQUEST_PICK2 = 0x0002;
    static final int REQUEST_OTHER = 0x0003;


    @OnActivityResult(REQUEST_REQUEST_PICK1)
    void resultPickImage1(int resultCode, Intent data) {
        Toast.makeText(this,
                String.format("resultPickImage1 code(%d)", resultCode),
                Toast.LENGTH_SHORT
        ).show();
    }

    @OnActivityResult(REQUEST_REQUEST_PICK2)
    void resultPickImage2(int resultCode, Intent data) {
        Toast.makeText(this,
                String.format("resultPickImage2 code(%d)", resultCode),
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!ActivityResult.invoke(this, requestCode, resultCode, data)) {
            // handle failed
            Toast.makeText(this,
                    String.format("failed request(%d) result(%d)", requestCode, resultCode),
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}

</pre>
