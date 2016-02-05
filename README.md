# OnActivityResult-invoke

## 概要

AndroidのActivity.onActivityResultとFragment.onActivityResultの処理を自動化するためのライブラリです。

Android Annotations風のAnnotation(@OnActivityResult)をメソッドに付与することで、自動的にメソッドの呼び出しを行います。Android Annotationsと違い、Refrectionを使用したランタイム処理を行うので、余計なクラス生成やビルド時間の長大化を引き起こさずに済みます。

## LICENSE

プロジェクトの都合に応じて、下記のどちらかを選択してください。ソースコードは自由に使ってもらって構いませんが、どんな不具合があっても責任は持ちません。

また、ライブラリ内で依存している別なライブラリについては、必ずそのライブラリのライセンスに従ってください。

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

<pre>
</pre>

### ExampleActivity.java

<pre>
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (ActivityResult.invoke(this, requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
</pre>
