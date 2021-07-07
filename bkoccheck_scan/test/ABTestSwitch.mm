//  Created by mjzheng on 19/01/10.
//  Copyright © 2019年 tencent. All rights reserved.
//

#import "ABTestSwitch.h"
#import <Codec/PbCodec.h>
#import "LCChannel.h"
#import "LCRoom.h"
#import "PLInfoStorageMgr.h"
#import "PLLoginMgr.h"
#import <Interface/ComponentMgr.h>
#import "PLUtilApp.h"
#import <Additions/UIDevice+Hardware.h>
#import "QQOfflineWebApp.h"
#import "ilive_util_abtest/ilive_util_abtest.pb.h"
#import "LCCommonSwitch.h"

#define LOG_FILTER @"LCABTestLog"
#define COMMON_ABTEST_STORAGE_KEY @"COMMON_ABTEST_STORAGE_KEY"
#define COMMON_ABTEST_STORAGE_DOMAIN @"COMMON_ABTEST_STORAGE_DOMAIN"

@implementation ABTestValue
@end

@interface LCABTestSwitch () <LCChannelDelegate>
{
    uint64_t _uid;
}

@property (nonatomic, weak) LCChannel *channel;
@end

@implementation LCABTestSwitch

-(id) init
{
    self = [super init];
    if (self != nil)
    {
        self.channel = nil;
    }
    return self;
}

#pragma mark 骡马实验平台-测试批量标签;

/*
函数：生成实验专用的测试Id逻辑
具体内容举例：
 "testIds": [
        "107028",
        "107029"
      ],
*/
-(NSMutableArray*)getTextWithIds{
    NSMutableArray * itemIDs = [[NSMutableArray alloc]init];
    NSString *     strIdA    = @"107028";
    NSString *     strIdB    = @"107029";
    NSArray  *     itemIds   = nil ;
    LCCommonSwitch * lpCommonSwitch = [LCCommonSwitch shareInstance];
    
    if( nil == itemIDs  ){
        LogFinal(LOG_FILTER, @"[ERROR]:媒体实验Id 分配内存出错");
        return itemIDs;
    }
    if( lpCommonSwitch != nil ){
        itemIds = [lpCommonSwitch getABLabIdConf];
    }
    if( itemIds.count <= 0 ){
        [itemIDs addObject:strIdA];
        [itemIDs addObject:strIdB];
        LogFinal(LOG_FILTER, @"媒体实验Id 走默认值逻辑，107028,107029");
    }else{
        [itemIDs addObjectsFromArray:itemIds];
    }
    LogFinal(LOG_FILTER, @"媒体实验Id %@",itemIDs);
    return itemIDs;
}


/*
 函数：生成实验专用的标签项目逻辑
 具体内容举例："jMapTagData": "{\"TestLabel\":[\"1\"]}",
 */
-(NSString*)getTextWithLabel{
    NSMutableDictionary * dict    = [[NSMutableDictionary alloc]init];
    NSString* pDevice             = [PLUtilApp GetDevicePlatform];
    NSString* pClientVersion      = [PLUtilApp getBundleVersionsStringShort] ;
    NSString* pOSVersion          = [[UIDevice currentDevice] systemVersion];
    NSString* pClientType         = [[NSString alloc] initWithFormat:@"%d",PL_CLIENT_TYPE_IOS];
    

    if( nil == dict  ){
        LogFinal(LOG_FILTER, @"[ERROR]:dict is nil");
        return @"";
    }
    if (nil != pDevice){
        NSMutableArray * item = [[NSMutableArray alloc]init];
        [item addObject:pDevice];
        [dict setValue:item forKey:@"device"];
    }else{
        LogFinal(LOG_FILTER, @"[ERROR]:device is nil");
    }
    if (nil != pOSVersion){
        NSMutableArray * item = [[NSMutableArray alloc]init];
        [item addObject:pOSVersion];
        [dict setValue:item forKey:@"osversion"];
    }else{
        LogFinal(LOG_FILTER, @"[ERROR]:osversion is nil");
    }
    if( nil != pClientVersion){
        NSMutableArray * item = [[NSMutableArray alloc]init];
        [item addObject:pClientVersion];
        [dict setValue:item forKey:@"clientversion"];
    }else{
        LogFinal(LOG_FILTER, @"[ERROR]:clientversion is nil");
    }
    if( pClientType != nil ){
        NSMutableArray * item = [[NSMutableArray alloc]init];
        [item addObject:pClientType];
        [dict setValue:item forKey:@"clienttype"];
    }else{
        LogFinal(LOG_FILTER, @"[ERROR]:clientype is nil");
    }
    NSData * json      = [NSJSONSerialization dataWithJSONObject:dict options:NSJSONWritingPrettyPrinted error:nil];
    NSString * jsonstr = [[NSString alloc]initWithData:json encoding:NSUTF8StringEncoding];
    LogFinal(LOG_FILTER, @"媒体实验标签 %@",jsonstr);
    return jsonstr;
}

/*
 @函数说明：当前函数用于请求骡马批量标签；可以实现骡马平台的自主实验配置；
 举例：上报标签纬度是：机型，OS版本，uin，网络，几个维度；地理位置；后续就可以自行组合哪些主播采用何种策略进行
 实验，后台自动输出对照组的数据；
 发包的格式
 {
   "appId": "now",
   "jMapTagData": "{\"TestLabel\":[\"1\"]}",
   "testIds": [
     "107028",
     "107029"
   ],
   "moduleName": "test2"
 }
 @日期：19年10月23日
 */
-(BOOL) requestSwitch
{
    LCChannel * currentChannel = [ComponentMgr getComponent:CHANNEL];
    int         seq            = 0;
    std::string message;
    
    if (self.channel != currentChannel)
    {
        self.channel = currentChannel;
    }
    CPBMessageEncoder pbEncoder;
    NSMutableArray * ids = [self getTextWithIds] ;
    NSString * mapdata   = [self getTextWithLabel];
    pbEncoder.AddStr(ilive_util_abtest_def::GetMatchedLabelABTestReq::string_appId, "now");
    pbEncoder.AddStr(ilive_util_abtest_def::GetMatchedLabelABTestReq::string_moduleName,"av_quality_improvement");
    for( int i = 0 ; i< ids.count  ; i++ ){
        pbEncoder.AddStr(ilive_util_abtest_def::GetMatchedLabelABTestReq::rpt_string_testIds,[ids[i] UTF8String]);
    }
    pbEncoder.AddStr(ilive_util_abtest_def::GetMatchedLabelABTestReq::string_jMapTagData,[mapdata UTF8String]);
    pbEncoder.Encode(message);
    return [self.channel sendData:[[NSData alloc] initWithBytes:message.data() length:message.size()] Command:ilive_util_abtest_def::ILIVE_UTIL_ABTEST withSubCmd:ilive_util_abtest_def::GetMatchedLabelABTest seq:&seq delegate:self];
}

#pragma mark LCChannelDelegate
- (void)onReceviceData:(LCMessage *)msg
{
    switch (msg.subcmd) {
        case ilive_util_abtest_def::GetMatchedLabelABTest:{
            [self onSwitchResponse:msg];
            break;
        }
        default:
            break;
    }
}
/*
 @函数：回包消息处理函数；
 当实验组 返回命中的实验组，就表示在实验组中，如果没有命中，返回0 ；
 */
- (void)onSwitchResponse:(LCMessage *)msg{
    CPBMessageDecoder decoder;
    
    if( msg == nil ){
        LogFinal(LOG_FILTER, @"[ERROR]:实验回包出错，参数为空");
        return ;
    }
    if (!decoder.Decode(msg.payload.bytes, (int)msg.payload.length))
    {
         LogFinal(LOG_FILTER, @"[ERROR]:实验回包出错，解包失败");
         return;
    }
     UINT32 result = decoder.GetUInt32(ilive_util_abtest_def::GetMatchedLabelABTestRsp::string_testId);
    
     if (result != 0)
     {
         return ;
     }
     LogFinal(LOG_FILTER, @"实验解析正常，实验组id=%d",result);
}

- (void)onError:(NSDictionary *)errInfo
{
    if (!errInfo) {
        return;
    }
    
    short cmd = [(NSNumber *)[errInfo objectForKey:@"command"] intValue];
    short subCmd = [(NSNumber *)[errInfo objectForKey:@"subcmd"] intValue];
    int bizCode = [errInfo[@"bizcode"] intValue];
    NSString *bizDesc = errInfo[@"bizdesc"];
    int sdkCode = [errInfo[@"sdkcode"] intValue];
    NSString *sdkDesc = errInfo[@"sdkdesc"];
    LogFinal(LOG_FILTER, @"LCRoomError,cmd=%d,subcmd=%d,bizCode=%d,bizDesc=%@,sdkCode=%d,sdkDesc=%@", cmd, subCmd, bizCode, bizDesc, sdkCode, sdkDesc);
    int errCode = 0;
    NSString *errMsg = nil;
    if (sdkCode != 0) {
        errCode = sdkCode;
        if (sdkCode == LCChannelErrorSDKCode_Timeout) {
            errCode = LCRoomErrorCode_Timeout;
        }
        
        errMsg = sdkDesc;
    } else {
        errCode = bizCode;
        errMsg = bizDesc;
    }
}

@end

